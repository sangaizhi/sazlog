package org.sangaizhi.common.util.tencent;

import java.io.File;
import java.util.Properties;

import cn.zyunc.ueasier.commons.utils.FileUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.common.exception.BusinessRuntimeException;
import org.sangaizhi.common.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.meta.InsertOnly;
import com.qcloud.cos.request.StatFolderRequest;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;


/**
 * @ClassName: COSUtils
 */
public class COSUtils
{
    private static Logger logger = LoggerFactory.getLogger(COSUtils.class);
    
    private static final long APP_ID = PropertiesUtil.getLong("COS_APP_ID");

    private static final String SECRET_ID = PropertiesUtil.getProperty("COS_SECRET_ID");

    private static final String SECRET_KEY = PropertiesUtil.getProperty("COS_SECRET_KEY");

    private static final String BUCKET_NAME = PropertiesUtil.getProperty("COS_BUCKET_NAME");

    private static final String REGION = PropertiesUtil.getProperty("COS_REGION");

    /** 文件类型 */
    public enum FILE_TYPE
    {
        /** 图片 */
        image(1),
        /** 视频 */
        vedio(2),
        /** 音频 */
        audio(3),
        /** 其他文件 */
        others(4);
        
        private int value;
        
        private FILE_TYPE(int value)
        {
            this.value = value;
        }
        
        public int getValue()
        {
            return this.value;
        }
    }
    
    /** 腾讯云文件夹 */
    private enum COS_FOLDER
    {
        /** 图片文件夹 */
        image,
        /** 视频文件夹 */
        vedio,
        /** 音频文件夹 */
        audio,
        /** 其他文件文件夹 */
        others;
    }
    
    /**
     * 初始化密钥信息类
     * 
     */
    public static Credentials initCredentials()
    {
        // 初始化秘钥信息
        Credentials cred = new Credentials(APP_ID, SECRET_ID, SECRET_KEY);
        return cred;
    }
    
    /**
     * 初始化腾讯云客户端对象
     * 
     */
    public static COSClient initCOSClient()
    {
        // 初始化秘钥信息
        Credentials cred = initCredentials();
        // 初始化客户端配置
        ClientConfig clientConfig = new ClientConfig();
        // 设置bucket所在的区域，比如广州(gz), 天津(tj)
        clientConfig.setRegion(REGION);
        // 初始化cosClient
        return new COSClient(clientConfig, cred);
    }
    
    /**
     * 上传文件到腾讯云并获取访问链接地址。（通过本地文件路径的方式）
     */
    public static String uploadFile(String localFilePath, Integer fileType)
    {
        if (StringUtils.isBlank(localFilePath))
        {
            throw new BusinessRuntimeException("", "本地文件路径为空");
        }
        if (fileType == null)
        {
            throw new BusinessRuntimeException("", "文件类型为空");
        }
        
        // 获取文件后缀名
        File file = new File(localFilePath);
        String fileName = FileUtil.getFileName(file);
        if (StringUtils.isBlank(fileName))
        {
            throw new BusinessRuntimeException("", "文件不存在");
        }
        // 设置腾讯云COS文件路径
        StringBuffer sb = new StringBuffer();
        // 设置腾讯云COS文件夹
        sb.append("/");
        switch (fileType)
        {
            case 1: // 图片文件夹
                sb.append(COS_FOLDER.image.toString());
                break;
            case 2: // 视频文件夹
                sb.append(COS_FOLDER.vedio.toString());
                break;
            case 3: // 音频文件夹
                sb.append(COS_FOLDER.audio.toString());
                break;
            case 4: // 其他文件夹
                sb.append(COS_FOLDER.others.toString());
                break;
        }
        sb.append("/");
        // 设置文件名
        sb.append(fileName);
        String cosPath = sb.toString();
        COSClient cosClient = null;
        try
        {
            UploadFileRequest uploadFileRequest =
                new UploadFileRequest(BUCKET_NAME, cosPath, localFilePath, InsertOnly.NO_OVER_WRITE.toString());
            cosClient = initCOSClient();
            String result = cosClient.uploadFile(uploadFileRequest);
            logger.info("上传文件到腾讯云的返回结果为：{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            Integer code = jsonObject.getInteger("code");
            String accessUrl = null;
            if (code == 0)
            {
                JSONObject innerJsonObject = jsonObject.getJSONObject("data");
                accessUrl = innerJsonObject.getString("access_url");
            }
            return accessUrl;
        }
        catch (Exception e)
        {
            logger.error("上传文件到腾讯云COS出现异常：", e);
            return null;
        }finally {
            if(null != cosClient){
                cosClient.shutdown();
            }
        }
    }
    
    /**
     * 检查文件夹是否存在
     */
    public static boolean isFolderExist(String folderName)
    {
        if (StringUtils.isBlank(folderName))
        {
            throw new BusinessRuntimeException("", "文件夹名字为空");
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append("/").append(folderName).append("/");
        String cosFolderPath = sb.toString();
        COSClient cosClient = initCOSClient();
        StatFolderRequest statFolderRequest = new StatFolderRequest(BUCKET_NAME, cosFolderPath);
        String result = cosClient.statFolder(statFolderRequest);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        boolean isExist = false;
        if (code == 0)
        {
            isExist = true;
        }
        return isExist;
    }
    
    /**
     * 获取文件夹属性
     */
    public static String statFolder(String cosFolderPath)
    {
        COSClient cosClient = initCOSClient();
        StatFolderRequest statFolderRequest = new StatFolderRequest(BUCKET_NAME, cosFolderPath);
        String result = cosClient.statFolder(statFolderRequest);
        logger.info("文件夹属性：{}", result);
        return result;
    }
}
