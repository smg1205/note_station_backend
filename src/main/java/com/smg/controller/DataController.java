package com.smg.controller;


import com.smg.module.Service.DataBaseService;
import com.smg.module.request.RequestToken;
import com.smg.module.responseEnity.ResponseList;
import com.smg.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class DataController {
    @Autowired
    DataBaseService dataBaseService;
    @Autowired
    ResponseList responseList;
    @PostMapping("/dataList")
    public ResponseList getList(@RequestBody RequestToken token){
        String username = TokenUtil.getUserName(token.getToken());
        System.out.println(username);
        responseList.setIl(dataBaseService.getUserList(username));
        if(responseList.getIl() != null){
            responseList.setReqMsg("获取成功");
        }
        System.out.println(responseList);
        return responseList;
    }
}
