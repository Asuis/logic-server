package com.real.logicserver.utils.user.model;

/**
 * @author asuis
 */
public class OurUserInfo {
    private Integer userId;
    private String nickName;
    private String avatarUrl;
    private Integer gender;
    private String language;
    private String city;
    private String province;
    private String country;

    public OurUserInfo() {
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public Integer getGender() {
        return this.gender;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCountry() {
        return this.country;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof OurUserInfo)) return false;
        final OurUserInfo other = (OurUserInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$nickName = this.getNickName();
        final Object other$nickName = other.getNickName();
        if (this$nickName == null ? other$nickName != null : !this$nickName.equals(other$nickName)) return false;
        final Object this$avatarUrl = this.getAvatarUrl();
        final Object other$avatarUrl = other.getAvatarUrl();
        if (this$avatarUrl == null ? other$avatarUrl != null : !this$avatarUrl.equals(other$avatarUrl)) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        final Object this$language = this.getLanguage();
        final Object other$language = other.getLanguage();
        if (this$language == null ? other$language != null : !this$language.equals(other$language)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$province = this.getProvince();
        final Object other$province = other.getProvince();
        if (this$province == null ? other$province != null : !this$province.equals(other$province)) return false;
        final Object this$country = this.getCountry();
        final Object other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $nickName = this.getNickName();
        result = result * PRIME + ($nickName == null ? 43 : $nickName.hashCode());
        final Object $avatarUrl = this.getAvatarUrl();
        result = result * PRIME + ($avatarUrl == null ? 43 : $avatarUrl.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        final Object $language = this.getLanguage();
        result = result * PRIME + ($language == null ? 43 : $language.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $province = this.getProvince();
        result = result * PRIME + ($province == null ? 43 : $province.hashCode());
        final Object $country = this.getCountry();
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof OurUserInfo;
    }

    public String toString() {
        return "OurUserInfo(userId=" + this.getUserId() + ", nickName=" + this.getNickName() + ", avatarUrl=" + this.getAvatarUrl() + ", gender=" + this.getGender() + ", language=" + this.getLanguage() + ", city=" + this.getCity() + ", province=" + this.getProvince() + ", country=" + this.getCountry() + ")";
    }
}