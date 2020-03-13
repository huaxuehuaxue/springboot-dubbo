package com.demo.dubbo.api.utils;

import java.text.SimpleDateFormat;

public class DateFormatUtil {

    public static SimpleDateFormat getCommonFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf;
    }
}
