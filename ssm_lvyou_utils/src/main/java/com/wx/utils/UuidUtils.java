package com.wx.utils;

import java.util.UUID;

public class UuidUtils {

    public static String createUuid(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        s = s.replace("-", "");
        return s;
    }

    public static void main(String[] args) {
        String uuid = createUuid();
        System.out.println(uuid);
    }
}
