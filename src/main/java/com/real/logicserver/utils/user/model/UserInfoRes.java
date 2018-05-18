package com.real.logicserver.utils.user.model;

public class UserInfoRes {

    /**
     * code : 200
     * data : {"avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/nh5xffgGyPf8E55ia3AxKxHYpMZRNnYOdad7OxjrlN0rjy0KnICyU4J8WY6icKW4GBKUbEGokWllTUvvpkVW6kvg/132","city":"Hangzhou","country":"China","gender":1,"language":"en","nickName":"孟杰","openId":"oAgY65Dqtd-8Zg4GoQ_7HCZ6cYUA","province":"Zhejiang"}
     * msg : check successful
     */

    private int code;
    private UserInfo data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
