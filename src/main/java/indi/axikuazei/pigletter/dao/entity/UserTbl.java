package indi.axikuazei.pigletter.dao.entity;

import java.util.Date;

public class UserTbl {
    private Integer userId;

    private String userName;

    private String pswd;

    private String nickName;

    private Byte gender;

    private Byte deleted;

    private Date registedTime;

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

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd == null ? null : pswd.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Date getRegistedTime() {
        return registedTime;
    }

    public void setRegistedTime(Date registedTime) {
        this.registedTime = registedTime;
    }
}