package com.smg.controller;

import com.smg.module.Service.DataBaseService;
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


@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileUploadController {
    @Autowired
    private DataBaseService dataBaseService;
    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }
            System.out.println("File content: " + fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/load/{fileUrl}")
    public String loadFile(@PathVariable("fileUrl") String fileUrl){
        return dataBaseService.getFileMd(fileUrl);
    }
}
