package indi.axikuazei.pigletter.dao.entity;


import java.util.Date;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
public class User {

    private int user_id;


    private String user_name;

    private String user_password;

    private String user_email;

    private Date register_date;

    public User(){};

    public User(int id, String user_username, String user_password, String user_email,Date register_date) {
        this.user_id=id;
        this.user_name = user_username;
        this.user_password = user_password;
        this.user_email = user_email;
        this.register_date = register_date;


    }

    public User(String user_username, String user_password) {
        this.user_name = user_username;
        this.user_password = user_password;
        this.register_date = new Date();
    }

    public User(String user_username, String user_password,String user_email) {
        this.user_name = user_username;
        this.user_password = user_password;
        this.user_email = user_email;
        this.register_date = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", user_username='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", register_date=" + register_date +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }


}
