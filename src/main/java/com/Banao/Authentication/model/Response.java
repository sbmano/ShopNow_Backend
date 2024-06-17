package com.Banao.Authentication.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T>{

    private Status status;
    private T payload;
    private Object errors;
    private Object metadata;
    private String message;

    public static <T> Response<T> ok(){
        Response<T> response=new Response<>();
        response.setStatus(Status.OK);
        return response;
    }

    public static <T> Response<T> notfound(){
        Response<T> response=new Response<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }
    public static <T> Response<T> internalServerError(){
        Response<T> response=new Response<>();
        response.setStatus(Status.INTERNAL_SERVER_ERROR);
        return response;
    }

    public enum Status{
        OK,NOT_FOUND,INTERNAL_SERVER_ERROR,NULL_POINTER,UNAUTOHRIZED,UPLOAD_FAILED;
    }
}
