package com.xzy.model;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private Integer userType;

    public void setUserType(Integer userType) { this.userType = userType; }

    public Integer getUserType() { return userType; }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }
}