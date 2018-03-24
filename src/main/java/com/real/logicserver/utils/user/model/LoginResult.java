package com.real.logicserver.utils.user.model;

/**
 * @author asuis
 */
public class LoginResult {
    private UserInfo userInfo;
    public LoginResult(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
