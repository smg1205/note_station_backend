package com.smg.utils;

public class GetTypeUtil {
    public static Boolean jdType(String fileName) {
        int length = fileName.length();
        StringBuilder typeBuilder = new StringBuilder();

        for (int i = length - 1; i >= 0; i--) {
            if (fileName.charAt(i) != '.') {
                typeBuilder.insert(0, fileName.charAt(i));
            } else {
                return typeBuilder.toString().equals("md");
            }
        }
        return typeBuilder.toString().equals("md");
    }

}
