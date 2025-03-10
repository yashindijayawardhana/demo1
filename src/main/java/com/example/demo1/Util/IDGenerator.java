package com.example.demo1.Util;

import java.util.UUID;

public class IDGenerator {
    public static String generateUniqueID() {
        return UUID.randomUUID().toString();
    }
}