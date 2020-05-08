package com.wx.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class  DateUtils {


    /**
     * 时间格式转换成字符串
     * @param data
     * @param patt
     * @return
     */
    public static String date2String(Date data ,String patt){
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);
        String newDate = dateFormat.format(data);
        return newDate;
    }

    /**
     * 字符串转换成时间格式
     * @param data
     * @param patt
     * @return
     */
    public static Date string2Date(String data ,String patt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);
        Date newDate = dateFormat.parse(data);
        return newDate;
    }
}
