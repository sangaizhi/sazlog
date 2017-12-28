package org.sangaizhi.common.util;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtil {


    /**
     * MD5加密
     * @param source 原字符串
     * @param iterations 加密次数 ,默认为1
     */
    public static String md5Hex(String source, Integer iterations){
        if (source == null) {
            return null;
        }
        if(null == iterations){
            iterations = 1;
        }
        String result = DigestUtils.md5Hex(source).toUpperCase();
        for(int i=1;i<iterations;i++){
            result = DigestUtils.md5Hex(result).toUpperCase();
        }
        return result;
    }

}
