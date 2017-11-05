package com.willshuhua.adibioadmin.dto.common;

/*
 * Copyright (c) 2017. willshuhua.
 */

public class Result {

    public final static String OK = "ok";
    public final static String ERR = "err";

    private String result = Result.OK;
    private String errMsg = "";
    private Object parm = null;

    public Result() {
    }

    public Result(String result, String errMsg, Object parm) {
        this.result = result;
        this.errMsg = errMsg;
        this.parm = parm;
    }

    public Result(String result, String errMsg) {
        this.result = result;
        this.errMsg = errMsg;
    }

    public Result(String result, Object parm) {
        this.result = result;
        this.parm = parm;
    }

    public Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getParm() {
        return parm;
    }

    public void setParm(Object parm) {
        this.parm = parm;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", parm=" + parm +
                '}';
    }

}