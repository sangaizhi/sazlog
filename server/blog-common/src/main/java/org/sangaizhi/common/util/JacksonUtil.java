
package org.sangaizhi.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson工具类
 * 
 * @author wupeng
 * @date 2017年5月24日 下午6:13:08
 */
public class JacksonUtil {

	private static ObjectMapper objectMapper;

	/**
	 * 把JavaBean转换为json字符串
	 * 
	 * @author wupeng
	 * @date 2017年5月24日 下午5:51:22
	 * @param object
	 * @return String
	 */
	public static String toJson(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toJson(Object object, Object... objects){
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			StringBuffer stringBuffer = new StringBuffer();
			if(null != object){
				stringBuffer.append(objectMapper.writeValueAsString(object));
			}
			if(null != objects && objects.length > 0){
				for(Object temp : objects){
					stringBuffer.append(objectMapper.writeValueAsString(temp));
				}
			}
			return objectMapper.writeValueAsString(stringBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 把json字符串转换为相应的JavaBean对象。
	 * 
	 * @author wupeng
	 * @date 2017年5月24日 下午5:49:31
	 * @param jsonStr
	 * @param javaBean
	 * @return T
	 */
	public static <T> T toJavaBean(String jsonStr, Class<T> javaBean) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(jsonStr, javaBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json数字字符串转换成集合
	 * 
	 * @author wupeng
	 * @date 2017年7月20日 上午11:34:56
	 * @param jsonStr
	 * @param typeReference
	 * @return T
	 */
	public static <T> T readValue(String jsonStr, TypeReference<T> typeReference) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(jsonStr, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
