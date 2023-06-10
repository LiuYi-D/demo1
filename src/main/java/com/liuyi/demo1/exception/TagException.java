package com.liuyi.demo1.exception;

public class TagException extends RuntimeException{
    private String errMessage;

    public TagException(){
        super();
    }

    public TagException(String message){

        super(message);
        this.errMessage = message;
    }
    public TagException(ErrorEnum errorEnum){
        throw new TagException(errorEnum.getErrMessage());
    }
}
