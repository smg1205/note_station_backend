package com.smg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.smg.mapper")
@SpringBootApplication
public class NoteStationBackend {
    public static void main(String[] args) {
        SpringApplication.run(NoteStationBackend.class, args);
    }
}
