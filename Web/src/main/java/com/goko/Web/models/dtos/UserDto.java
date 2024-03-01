package com.goko.Web.models.dtos;

import com.goko.Web.models.UserModel;
public class UserDto {
    private String title;
    private UserModel user;

    public UserDto(String title, UserModel user) {
        this.title = title;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
