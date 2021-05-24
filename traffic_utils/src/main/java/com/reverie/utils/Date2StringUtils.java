package com.reverie.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2StringUtils {

    public static String date2String(Date currentTime){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String dateString(Date currentTime){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
