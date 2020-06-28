package web;

import java.io.Serializable;

public class WebResult implements Serializable {
    private int state;
    private Object data;
    private String details;

    public static WebResult getResult(int state, Object data, String details) {
        return new WebResult(state, data, details);
    }

    public static WebResult shouldLogin(){
        return new WebResult(NEED_LOGIN, "", "");
    }

    public static WebResult success(){
        return new WebResult(OK,null,null);
    }

    public static WebResult error(String data){
        return new WebResult(ERROR,data,null);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public WebResult(int state, Object data, String details) {
        this.state = state;
        this.data = data;
        this.details = details;
    }

    public static final int NULL = 0;//空
    public static final int OK = 200;
    public static final int PASSWORD_ERROR = 201;
    public static final int USER_NULL = 202;//用户名不存在
    public static final int NEED_LOGIN = 203;//需要登录
    public static final int ERROR=222;
}
