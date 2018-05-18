package com.real.logicserver.social.friend.dto;

/**
 * @author asuis
 */
public class FriendSimpleInfo {
    private String fid;
    private String avatar;
    private String nickName;

    public String getFid() {
        return this.fid;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNikeName() {
        return this.nickName;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setNikeName(String nikeName) {
        this.nickName = nikeName;
    }
}
