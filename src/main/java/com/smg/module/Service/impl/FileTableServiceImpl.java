package com.smg.module.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smg.module.domain.FileTable;
import com.smg.module.Service.FileTableService;
import com.smg.mapper.FileTableMapper;
import org.springframework.stereotype.Service;

/**
* @author 34861
* @description 针对表【file_table(存储文件信息的表)】的数据库操作Service实现
* @createDate 2024-11-20 09:16:10
*/
@Service
public class FileTableServiceImpl extends ServiceImpl<FileTableMapper, FileTable>
    implements FileTableService{

}




