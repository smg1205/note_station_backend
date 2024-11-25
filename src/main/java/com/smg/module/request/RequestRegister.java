package com.smg.module.request;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class RequestRegister {
    private String email;
    private String username;
    private String password;
    private String checkPassword;
}
