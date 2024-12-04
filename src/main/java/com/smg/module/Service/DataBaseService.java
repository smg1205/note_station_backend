package com.smg.module.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smg.module.Enums.ResponseMessages;
import com.smg.module.dbService.FileTableService;
import com.smg.module.dbService.UserTableService;
import com.smg.module.dbService.impl.MongoService;
import com.smg.module.domain.FileTable;
import com.smg.module.domain.UserTable;
import com.smg.module.responseEnity.ResponseItem;
import com.smg.module.responseEnity.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseService {
    @Autowired
    private UserTable insertUser;
    @Autowired
    private MongoService mongoService;
    @Autowired
    private UserTableService userTableService;

    @Autowired
    private FileTable addFile;
    @Autowired
    private FileTableService fileTableService;
    @Autowired
    private List<ResponseItem> returnList;
    public List<ResponseItem> getUserList(String userName){
        QueryWrapper<FileTable> qw1 = new QueryWrapper<>();
        returnList = new ArrayList<>();
        qw1.eq("owner", userName);
        List<FileTable> li = fileTableService.list(qw1);
        for(FileTable f : li) {
            ResponseItem r1 = new ResponseItem();
            r1.setCreateTime(String.valueOf(f.getFileCreateTime()));
            r1.setFilename(f.getFilename());
            r1.setFileUrl(f.getFileUrl());
            if(r1.getFilename() != null && r1.getFileUrl() != null && r1.getCreateTime() != null){
                returnList.add(r1);
            }
        }
        return returnList;
    }
    public Boolean updateUserData(String fileUrl, String filename,String username){
        FileTable insertFile = new FileTable();
        insertFile.setFilename(filename);
        insertFile.setFileUrl(fileUrl);
        insertFile.setOwner(username);
        return fileTableService.save(insertFile);
    }

    public Boolean addViewCount(String fileUrl){
        QueryWrapper<FileTable> qw1 = new QueryWrapper<>();
        qw1.eq("fileUrl", fileUrl);
        addFile = fileTableService.getOne(qw1);
        if(addFile != null){
            addFile.setViewCount(addFile.getViewCount() + 1);
        }
        return fileTableService.update(addFile, qw1);
    }

    public String getFileMd(String fileUrl){
        String fileContext = null;
        try{
            fileContext = mongoService.getOneFile(fileUrl).getFileContext();
        }catch (NullPointerException e){
            fileContext = "# ERROR";
        }
        return fileContext;
    }
    public Boolean uploadFileMd(String fileContext, String fileUrl){
        return mongoService.insertFile(fileUrl, fileContext, "md");
    }
    public String loginService(String userName, String password){
        try{
            QueryWrapper<UserTable> qw1 = new QueryWrapper<>();
            qw1.eq("userName", userName);
            UserTable user1 =  userTableService.getOne(qw1);
            if(user1 == null){
                return ResponseMessages.LOGIN_FAIL_ACCOUNT_NOT_EXIST;
            }
            if(user1.getPassword().equals(password)){
                return ResponseMessages.LOGIN_SUCCESS;
            }
        }catch (Exception e){
            System.err.println(e);
            return ResponseMessages.LOGIN_FAIL_SYSTEM_NO_RESPONSE;
        }

        return ResponseMessages.LOGIN_FAIL_PASSWORD_ERROR;
    }
    public String registerService(String userName, String password, String email){
        try{
            QueryWrapper<UserTable> qw1 = new QueryWrapper<>();
            qw1.eq("userName", userName);
            UserTable user1 = userTableService.getOne(qw1);
            if(user1 == null){
                insertUser.setEmail(email);
                insertUser.setPassword(password);
                insertUser.setUserName(userName);
                if(userTableService.save(insertUser)){
                    return ResponseMessages.REGISTER_SUCCESS;
                }
            }else{
                return ResponseMessages.REGISTER_FAIL_ACCOUNT_EXISTS;
            }
        }catch (Exception e){
            System.out.println(e);
            return ResponseMessages.REGISTER_FAIL_SYSTEM_NO_RESPONSE;
        }
        return ResponseMessages.REGISTER_FAIL_SYSTEM_NO_RESPONSE;
    }
    public String checkEmailService(String email){
        try{
            QueryWrapper<UserTable> qw1 = new QueryWrapper<>();
            qw1.eq("email", email);
            if(userTableService.getOne(qw1) == null){
                return ResponseMessages.REGISTER_CHECK_EMAIL_SUCCESS;
            }
        }catch (Exception e){
            System.out.println(e);
            return ResponseMessages.REGISTER_CHECK_EMAIL_EXISTS;
        }
        return ResponseMessages.REGISTER_FAIL_SYSTEM_NO_RESPONSE;
    }
}
