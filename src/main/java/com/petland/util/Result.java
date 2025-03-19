package com.petland.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用响应结果类
 */
public class Result {
    
    private Integer code;
    private String message;
    private Object data;
    
    private Result() {
    }
    
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("操作成功");
        return result;
    }
    
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }
    
    public static Result success(String message, Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    
    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMessage("操作失败");
        return result;
    }
    
    public static Result error(String message) {
        Result result = new Result();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }
    
    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    public Result put(String key, Object value) {
        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }
        ((Map) this.data).put(key, value);
        return this;
    }
}
