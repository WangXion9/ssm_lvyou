package com.wx.utils;

import java.io.UnsupportedEncodingException;

public class MyStringUtils {

    /**
     * 服务器字符串转换，转换成utf-8格式
     * @param s
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String create2UTF8(String s) throws UnsupportedEncodingException {
        s = new String(s.getBytes("ISO-8859-1"),"utf-8");
        return s;
    }
}
