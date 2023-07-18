package com.group3.issizsiniz.config;

import java.util.Objects;

public class SecurityConfig {

    public static boolean matchPassword(String request, String user){
        return Objects.equals(request, user);
    }

    public static String encodePassword(String password) {
        return "password";
    }
}
