package com.smg.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

public class TokenUtil {
    public static String getToken(String userName, String password){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR,24);
        return JWT.create()
                .withClaim("userName", userName)
                .withClaim("password", password)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("smg"));
    }
    public static String getUserName(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("smg")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT.getClaim("userName").asString();
    }
    public static String getPassword(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("smg")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT.getClaim("password").asString();
    }
    public static Date getExpires(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("smg")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT.getExpiresAt();
    }
}
