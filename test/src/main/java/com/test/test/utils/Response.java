package com.test.test.utils;

import lombok.Data;

@Data
public class Response {

    private boolean isok;
    private int code; //200\400\500
    private String message;
    private Object data;

    private Response(){}

    public static Response success() {
        Response response = new Response();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }

    public static Response success(String message) {
        Response response = new Response();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage(message);
        return response;
    }

    public static Response success(Object obj) {
        Response response = new Response();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage("Success");
        response.setData(obj);
        return response;
    }

    public static Response success(Object obj, String message) {
        Response response = new Response();
        response.setIsok(true);
        response.setCode(200);
        response.setMessage(message);
        response.setData(obj);
        return response;
    }

    public static Response failed(String message) {
        Response response = new Response();
        response.setIsok(false);
        response.setCode(500);
        response.setMessage(message);
        return response;
    }

}
