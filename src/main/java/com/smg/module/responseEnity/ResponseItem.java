package com.smg.module.responseEnity;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ResponseItem {
    private String filename;
    private String createTime;
    private String fileUrl;
}
