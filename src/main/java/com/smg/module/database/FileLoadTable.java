package com.smg.module.database;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
@Service
@Document("fileLoadData")
public class FileLoadTable implements Serializable {
    @Id
    private String id;
    private String fileUrl;
    private String fileContext;
    private String fileType;
}
