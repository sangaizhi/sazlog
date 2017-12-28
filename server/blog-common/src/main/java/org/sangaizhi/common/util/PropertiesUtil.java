package org.sangaizhi.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sangaizhi
 * @date 2017/9/24
 */
public class PropertiesUtil {


        private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);


        private static final Properties properties = new Properties();

        static {
            InputStream inputStream = null;
            try {
                inputStream = PropertiesUtil.class.getResourceAsStream("/application.properties");
                if (inputStream == null) {
                    inputStream = PropertiesUtil.class.getResourceAsStream("/environment.properties");
                }
                properties.load(inputStream);
            } catch (IOException e) {
                logger.error("配置文件加载失败!", e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        logger.error("输入流关闭失败!", e);
                    }
                }
            }
        }

        public static Properties getProperties() {
            return properties;
        }


    /**
     * 读取系统配置文件根据属性名获取属性值
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (StringUtils.isNotBlank(value)) {
            value = StringUtils.trim(value);
        }
        return value;
    }

    public static String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        if (value != null) {
            return value;
        } else {
            return defaultValue;
        }
    }


    public static Integer getInteger(String key) {
        return Integer.valueOf(getProperty(key));
    }

    public static Integer getInteger(String key, Integer defaultValue) {
        return Integer.valueOf(getProperty(key, String.valueOf(defaultValue)));
    }

    public static Boolean getBoolean(String key) {
        return Boolean.valueOf(getProperty(key));
    }

    public static Boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.valueOf(getProperty(key, String.valueOf(defaultValue)));
    }

    public static Long getLong(String key) {
        return Long.valueOf(getProperty(key));
    }

}
