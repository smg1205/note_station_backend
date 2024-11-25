package com.smg.controller;


import com.smg.module.Enums.ResponseMessages;
import com.smg.module.Service.DataBaseService;
import com.smg.module.request.RequestLogin;
import com.smg.module.request.RequestRegister;
import com.smg.module.responseEnity.ResponseEmailCode;
import com.smg.module.responseEnity.ResponseLogin;
import com.smg.module.responseEnity.ResponseRegister;
import com.smg.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    ResponseLogin responseLogin;
    @Autowired
    ResponseRegister responseRegister;
    @Autowired
    DataBaseService dataBaseService;
    @Autowired
    ResponseEmailCode responseEmailCode;
    @PostMapping("/login")
    public ResponseLogin login(@RequestBody RequestLogin login){
        String password = login.getPassword();
        String userName = login.getUsername();
        System.out.println(userName + " " + password);
        if(userName == null || password == null){
            responseLogin.setToken("ERROR");
            responseLogin.setResMsg(ResponseMessages.LOGIN_FAIL_ACCOUNT_NOT_EXIST);
        }
        responseLogin.setResMsg(dataBaseService.loginService(userName, password));
        if(responseLogin.getResMsg().equals("登录成功，即将跳转到主页")){
            responseLogin.setToken(TokenUtil.getToken(userName,password));
        }else{
            responseLogin.setToken("ERROR");
        }
        return responseLogin;
    }
    @PostMapping("/register")
    public ResponseRegister register(@RequestBody RequestRegister register){
        String password = register.getPassword();
        String userName = register.getUsername();
        String checkPassword = register.getCheckPassword();
        String email = register.getEmail();
        if(password.length() < 8){
            responseRegister.setResMsg(ResponseMessages.REGISTER_FAIL_PASSWORD_LENGTH);
        }
        if(userName.length() < 4){
            responseRegister.setResMsg(ResponseMessages.REGISTER_FAIL_USERNAME_LENGTH);
        }
        if(!checkPassword.equals(password)){
            responseRegister.setResMsg(ResponseMessages.REGISTER_CHECK_PASSWORD_MISMATCH);
        }
        // NTODO Redis获取邮箱验证码

        responseRegister.setResMsg(dataBaseService.registerService(userName, password, email));

        if(responseRegister.getResMsg().equals("注册成功，即将跳转到主页")){
            responseRegister.setToken(TokenUtil.getToken(userName,password));
        }else{
            responseRegister.setToken("ERROR");
        }
        return responseRegister;
    }
    @PostMapping("/checkEmail")
    public ResponseEmailCode checkEmail(@RequestBody RequestRegister register){
        String email = register.getEmail();
        try{
            if(dataBaseService.checkEmailService(email).equals(ResponseMessages.REGISTER_CHECK_EMAIL_SUCCESS)){
                responseEmailCode.setReqMsg(ResponseMessages.REGISTER_CHECK_EMAIL_SUCCESS);
            }else{
                responseEmailCode.setReqMsg(ResponseMessages.REGISTER_CHECK_EMAIL_EXISTS);
            }
        }catch (Exception e){
            System.out.println(e);
            responseEmailCode.setReqMsg(ResponseMessages.REGISTER_FAIL_SYSTEM_NO_RESPONSE);
        }

        return responseEmailCode;
    }
}
