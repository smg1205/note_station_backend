package com.smg.module.request;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class RequestLogin {
    private String username;
    private String password;
}
