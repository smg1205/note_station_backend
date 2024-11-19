package com.smg.module.Service;

import com.smg.module.database.FileLoadTable;
import com.smg.module.dbService.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseService {
    @Autowired
    public MongoService mongoService;
    public String getFileMd(String fileUrl){
        String fileContext = null;
        try{
            fileContext = mongoService.getOneFile(fileUrl).getFileContext();
        }catch (NullPointerException e){
            fileContext = "# ERROR";
        }
        return fileContext;
    }
}
