package org.sangaizhi.common.util;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.common.util.tencent.COSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author sangaizhi
 * @date 2017/9/24
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 保存经过base64编码过的图片文件
     */
    public static void saveFile(String base64file, File targetFile)
    {
        try
        {
            if (!targetFile.exists())
            {
                targetFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(targetFile);
            FileChannel fc = fos.getChannel();
            BASE64Decoder decoder = new BASE64Decoder();
            ByteBuffer bb = decoder.decodeBufferToByteBuffer(base64file);
            fc.write(bb);
            fos.flush();
            fc.close();
            fos.close();
        }
        catch (Exception e)
        {
            logger.error("文件保存失败！", e);
        }
    }

    /**
     * 上传文件到腾讯云COS。文件类型参数务必使用COSUtils类的<codeFILE_TYPE枚举值
     * @param file 需上传的文件
     * @param fileType 文件类型 参照 文件类型参数务必使用COSUtils类的FILE_TYPE 枚举值
     */
    public static String uploadFileToCOS(File file, Integer fileType)
    {
        if (file == null || fileType == null)
        {
            return null;
        }
        if (!file.exists())
        {
            return null;
        }
        if (file.isDirectory())
        {
            return null;
        }
        // 上传文件到腾讯云COS
        String localFilePath = file.getAbsolutePath();
        String imageCOSUrl = COSUtils.uploadFile(localFilePath, fileType);
        // 上传成功后删除本地文件
        if (imageCOSUrl != null)
        {
            file.delete();
        }
        return imageCOSUrl;
    }

    /**
     * 上传base64编码的图片文件到腾讯云COS
     */
    public static String uploadBase64ImageFileToCOS(String base64file)
    {
        if (StringUtils.isBlank(base64file))
        {
            return null;
        }
        // 生成临时文件夹
        String tempDir = buildTempDir();
        // 生成jpeg文件名
        String fileName = generateJPEGFileName();
        // 生成文件保存路径
        File file = new File(tempDir + "/" + fileName);
        // 保存文件
        FileUtil.saveFile(base64file, file);
        // 上传文件到腾讯云COS
        String localFilePath = file.getAbsolutePath();
        String imageCOSUrl = COSUtils.uploadFile(localFilePath, COSUtils.FILE_TYPE.image.getValue());
        // 上传成功后删除本地文件
        if (imageCOSUrl != null)
        {
            file.delete();
        }
        return imageCOSUrl;
    }

    /**
     * 创建图片文件名，年月日时分秒毫秒+.jpeg文件后缀名 图片。文件格式为jpeg
     */
    public static String generateJPEGFileName()
    {
        return generateFileName() + ".jpeg";
    }

    /**
     * 按年月日时分秒毫秒生成文件名
     */
    public static String generateFileName()
    {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (int) (Math.random() * 9000 + 1000);
    }

    /**
     * 创建临时文件夹并返回临时文件夹路径
     */
    public static String buildTempDir()
    {
        String tempDirPath = getRootPath() + "TempDir";
        return buildDirPath(tempDirPath);
    }
    /**
     * 获取文件存放的根目录
     */
    public static String getRootPath()
    {
        String path = PropertiesUtil.getProperty("SYSTEM_FILE_PATH");
        if (StringUtils.isBlank(path))
        {
            String osName = System.getProperty("os.name");
            if (osName.contains("Windows"))
            {
                path = "D:\\static\\zlog\\";
            }
            else
            {
                path = "/home/static/zlog/";
            }
        }
        return path;
    }

    /**
     * 创建目标文件夹并返回文件夹路径
     * @return
     */
    public static String buildDirPath(String dirPath)
    {
        if (StringUtils.isBlank(dirPath))
        {
            return null;
        }
        File targetDir = new File(dirPath.trim());
        if (!targetDir.exists())
        {
            targetDir.mkdirs();
        }
        return dirPath;
    }





}
