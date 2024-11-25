package com.smg.module.responseEnity;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ResponseEmailCode {
    private String reqMsg;
    private Integer emailCode;
}
