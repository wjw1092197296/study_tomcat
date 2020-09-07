package com.wjw;

/**
 * @description: http请求method枚举
 * @author: wjw
 * @date 2020/9/3 21:00
 */
public enum MethodEnum {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    HEAD("HEAD"),
    DELETE("DELETE"),
    OPTION("OPTION");

    private String method;

    private MethodEnum(String method) {
        this.method = method;
    }

    public MethodEnum values(String method){
        switch(method){
            case "GET":
                return MethodEnum.GET;
            case "POST":
                return MethodEnum.POST;
            case "PUT":
                return MethodEnum.PUT;
            case "PATCH":
                return MethodEnum.PATCH;
            case "HEAD":
                return MethodEnum.HEAD;
            case "DELETE":
                return MethodEnum.DELETE;
            case "OPTION":
                return MethodEnum.OPTION;
            default:
                return null;
        }
    }


}
