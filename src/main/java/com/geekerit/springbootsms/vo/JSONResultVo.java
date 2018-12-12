package com.geekerit.springbootsms.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


public class JSONResultVo implements Serializable{

    @Getter
    @Setter
    private Boolean success = true;

    @Getter
    private String errorMsg;

    @Getter
    @Setter
    private Object result;

    public void setErrorMsg(String msg){
        this.success = false;
        this.errorMsg = msg;
    }
}
