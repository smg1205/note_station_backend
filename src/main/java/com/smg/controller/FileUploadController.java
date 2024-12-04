package com.smg.controller;

import cn.hutool.core.util.HashUtil;
import cn.hutool.crypto.SecureUtil;
import com.smg.module.Service.DataBaseService;
import com.smg.utils.TimeUtil;
import com.smg.utils.TokenUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static com.smg.utils.GetTypeUtil.jdType;


@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileUploadController {
    @Autowired
    private DataBaseService dataBaseService;
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("token") String token) throws IOException {
        InputStream inputStream = file.getInputStream();
        String fileName = file.getOriginalFilename();
        String username = TokenUtil.getUserName(token);

        if (fileName != null && !jdType(fileName)) {
            return "ERROR";
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }
            String time = TimeUtil.getTime(new Date().getTime());
            String fileUrl = SecureUtil.md5(time);
            Boolean jd = dataBaseService.updateUserData(fileUrl,fileName, username);
            if(jd){
                if(dataBaseService.uploadFileMd(fileContent.toString(), fileUrl)){
                    return "SUCCESS";
                }
            }else{
                System.out.println("文件已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "FAIL";
    }
    @GetMapping("/load/{fileUrl}")
    public String loadFile(@PathVariable("fileUrl") String fileUrl){
        dataBaseService.addViewCount(fileUrl);
        return dataBaseService.getFileMd(fileUrl);
    }
}
