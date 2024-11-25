package com.smg.module.responseEnity;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ResponseRegister {
    private String token;
    private String resMsg;
}
