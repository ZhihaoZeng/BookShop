package com.bookshop.entity;

/*用户*/
public class User {
    private Integer userId;
    private String userName;
    private String gender;
    private String userAddress;
    private String userPassword;
    private String userStatus;

    public User(Integer userId, String userName, String gender, String userAddress, String userPassword, String userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
    }

    public User() {
    }

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
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
