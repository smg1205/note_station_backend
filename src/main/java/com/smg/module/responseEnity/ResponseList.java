package com.smg.module.responseEnity;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ResponseList {
    private String reqMsg;
    private List<ResponseItem> il;
}

