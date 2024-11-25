package com.smg.module.dbService.impl;

import com.smg.module.database.FileLoadTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private FileLoadTable fileLoadTable;
    public FileLoadTable getOneFile(String fileUrl){
        try{
            Query query = new Query();
            query.addCriteria(Criteria.where("fileUrl").is(fileUrl));
            fileLoadTable = mongoTemplate.findOne(query, FileLoadTable.class, "fileLoadData");
        }catch (NullPointerException e){
            fileLoadTable = new FileLoadTable();
        }
        return fileLoadTable;
    }
    public Boolean insertFile(String fileUrl, String fileContext, String fileType){
        fileLoadTable.setFileUrl(fileUrl);
        fileLoadTable.setFileType(fileType);
        fileLoadTable.setFileContext(fileContext);
        try{
            mongoTemplate.insert(fileLoadTable);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
