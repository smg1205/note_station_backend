package com.smg.controller;


import com.smg.module.request.RequestLogin;
import com.smg.module.request.RequestRegister;
import com.smg.module.requestEnity.ResponseLogin;
import com.smg.module.requestEnity.ResponseRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    ResponseLogin responseLogin;
    @Autowired
    ResponseRegister responseRegister;
    @PostMapping("/login")
    public ResponseLogin login(@RequestBody RequestLogin login){
        return responseLogin;
    }
    @PostMapping("/register")
    public ResponseRegister register(@RequestBody RequestRegister register){
        return responseRegister;
    }
}
