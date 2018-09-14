package com.pinyougou.vo;

/**
 * Date:2018/9/9
 */
public class Result {
    private Boolean success;
    private String msg;


    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static Result ok (String  msg){

        return  new Result(true,msg);
    }
    public static Result  fail(String  msg){

        return  new Result(false,msg);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
