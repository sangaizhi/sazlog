package org.sangaizhi.common.exception;

import java.util.Map;

public class BusinessRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -4453231439181616823L;
    private String errCode;
    private String errMsg;
    private Map<String, Object> errMap;

    public BusinessRuntimeException(String errCode, String errMsg, Map<String, Object> errMap) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errMap = errMap;
    }

    public BusinessRuntimeException(String errCode, String errMsg) {
        this(errCode, errMsg, (Map)null);
    }

    public BusinessRuntimeException(String errCode, String errMsg, Map<String, Object> errMap, Throwable throwable) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errMap = errMap;
    }

    public BusinessRuntimeException(String errCode, String errMsg, Throwable throwable) {
        this(errCode, errMsg, (Map)null, throwable);
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Object> getErrMap() {
        return this.errMap;
    }

    public void setErrMap(Map<String, Object> errMap) {
        this.errMap = errMap;
    }
}
