package com.smg;

import cn.hutool.crypto.SecureUtil;
import com.smg.utils.TimeUtil;
import com.smg.utils.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class NoteStationBackendTest {
    @Test
    void contextLoads() {
        String token = TokenUtil.getToken("admin","admin");
        System.out.println(token);
        System.out.println(TokenUtil.getUserName(token));
        System.out.println(TokenUtil.getPassword(token));
        System.out.println(TokenUtil.getExpires(token));
    }
    @Test
    void test(){
        String time = TimeUtil.getTime(new Date().getTime());

        String ss = SecureUtil.md5(time + "hello,world");
        System.out.println(ss);
    }
    @Test
    void test1(){
        String username = TokenUtil.getUserName("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkVseXNtZyIsInBhc3N3b3JkIjoiU0hJbGluZ2tlZGFvNTQ2MiIsImV4cCI6MTczMzM1OTQ0M30.Z-rqHhBK6jBWxGyfRqJpTx6zYiV1qiqL7xK0HRktgpc");
        System.out.println(username);
    }

}
