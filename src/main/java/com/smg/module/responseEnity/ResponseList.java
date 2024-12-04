package com.smg.module.responseEnity;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Scope("prototype")
public class ResponseList {
    private String reqMsg;
    private List<ResponseItem> il;
}

