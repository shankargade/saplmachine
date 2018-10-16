package com.appsplanet.test.saplmachine;

import java.io.Serializable;

public class Data implements Serializable {

    private String id;
    private  String firstname;
    private String lastname;
    private String avatar;


    public Data(String id, String firstname, String lastname, String avatar) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.avatar = avatar;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
