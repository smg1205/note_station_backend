package com.smg.utils;


import cn.hutool.core.util.HashUtil;

import java.util.Date;

public class SendEmail {
    public static String getCode(String username){
        int ans = HashUtil.apHash(username + TimeUtil.getTime(new Date().getTime()));
        return Integer.toString(Math.abs(((ans + 1000000) % 1000000)));
    }
    public static Boolean sendEmail(String email, String username){

        return false;
    }
}
