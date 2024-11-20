package com.smg.module.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smg.module.domain.UserTable;
import com.smg.module.Service.UserTableService;
import com.smg.mapper.UserTableMapper;
import org.springframework.stereotype.Service;

/**
* @author 34861
* @description 针对表【user_table(存储用户基本信息的表)】的数据库操作Service实现
* @createDate 2024-11-20 09:18:27
*/
@Service
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper, UserTable>
    implements UserTableService{

}




