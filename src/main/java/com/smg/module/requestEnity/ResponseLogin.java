package com.smg.module.requestEnity;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ResponseLogin {
    private String token;
    private String resMsg;
}
