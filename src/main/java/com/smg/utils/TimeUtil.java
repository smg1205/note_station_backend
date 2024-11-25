package com.smg.utils;

public class TimeUtil {
    public static String getTime(long time){
        StringBuilder stringBuilder = new StringBuilder();
        while(time != 0){
            stringBuilder.append(time % 10);
            time /= 10;
        }
        return stringBuilder.reverse().toString();
    }
}
