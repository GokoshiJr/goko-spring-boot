package com.goko.Web.models;

import lombok.*;

@Data
public class UserModel {

    private String name;
    private String lastname;
    private String email;

    public UserModel(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public UserModel(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public UserModel() {}
}
