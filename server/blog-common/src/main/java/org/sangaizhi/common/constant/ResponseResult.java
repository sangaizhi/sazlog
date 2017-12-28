package org.sangaizhi.common.constant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/8/24
 */
public class ResponseResult implements Serializable {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Boolean status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResponseResult build(Boolean status, String msg, Object data) {
        return new ResponseResult(status, msg, data);
    }


    public static ResponseResult ok() {
        return new ResponseResult(true, "", null);
    }
    public static ResponseResult ok(String msg){
        return new ResponseResult(true, msg, null);
    }
    public static ResponseResult ok(String msg, Object data){
        return new ResponseResult(true, msg, data);
    }

    public static ResponseResult fail(){
        return new ResponseResult(false, "", null);
    }
    public static ResponseResult fail(String msg){
        return new ResponseResult(false, msg, null);
    }
    public static ResponseResult fail(String msg, Object data){
        return new ResponseResult(false, msg, data);
    }

    public ResponseResult() {

    }

    public static ResponseResult build(Boolean status, String msg) {
        return new ResponseResult(status, msg, null);
    }

    public ResponseResult(Boolean status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为ResponseResult对象
     *
     * @param jsonData json数据
     * @param clazz ResponseResult中的object类型
     * @return
     */
    public static ResponseResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ResponseResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").asBoolean(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static ResponseResult format(String json) {
        try {
            return MAPPER.readValue(json, ResponseResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ResponseResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").asBoolean(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }


}
