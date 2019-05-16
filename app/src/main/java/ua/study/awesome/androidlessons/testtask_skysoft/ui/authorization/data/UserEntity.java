package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data;

import io.realm.RealmObject;

public class UserEntity extends RealmObject {

    private String UserName;
    private String email;
    private String password;

    public UserEntity() {}

    public UserEntity(String userName, String email, String password) {
        UserName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}