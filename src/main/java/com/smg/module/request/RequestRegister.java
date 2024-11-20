package com.smg.module.request;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class RequestRegister {
    private String userName;
    private String password;
    private String email;
    private String eCode;
}
