package com.lingjiancong.annotations;

/**
 * Created by lenovo on 2016/9/5.
 */
public class PasswordUtils {

    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }
}
