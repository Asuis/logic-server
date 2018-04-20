package com.real.logicserver.utils.user.model;

public class Res {

    /**
     * code : 200
     * data : {"avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/nh5xffgGyPf8E55ia3AxKxHYpMZRNnYOdad7OxjrlN0rjy0KnICyU4J8WY6icKW4GBKUbEGokWllTUvvpkVW6kvg/0","city":"Hangzhou","country":"China","gender":1,"language":"zh_CN","nickName":"孟杰","province":"Zhejiang","userId":16}
     * msg : check successful
     */

    private Integer code;
    private OurUserInfo data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public OurUserInfo getData() {
        return data;
    }

    public void setData(OurUserInfo data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}