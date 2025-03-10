package com.example.demo1.Util;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z\\s]+$");
    }
}