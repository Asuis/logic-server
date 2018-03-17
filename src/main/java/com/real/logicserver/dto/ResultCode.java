package com.real.logicserver.dto;

/**
 * @author asuis
 */
public enum  ResultCode {
    /**
     * succ 表示成功
     * fail 表示失败
     * created 表示创建
     */
    SUCC(200),
    FAIL(500),
    CREATED(201),
    CONTINUE(100),
    ACCEPTED(202),
    NO_CONTENT(204),
    FOUND(302),
    SEE_OTHER(303),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    REQUEST_TIMEOUT(408),
    CONFLICT(409),
    LENGTH_REQUIRED(411),
    REQUEST_ENTITY_TOO_LARGE(413),
    TOO_MANY_REQUESTS(429),
    NOT_IMPLEMENTED(501),
    SERVICE_UNAVAILABLE(503),
    GATEWAY_TIMEOUT(504),
    HTTP_VERSION_NOT_SUPPORTED(505);


    private Integer code;

    ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code.toString();
    }
}
