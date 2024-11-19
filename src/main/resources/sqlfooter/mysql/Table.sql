create database note_station;
USE note_station;
CREATE TABLE user_table (
       id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，唯一标识每个用户',
       userName VARCHAR(255) NOT NULL COMMENT '用户名，不能为空',
       password VARCHAR(255) NOT NULL COMMENT '密码，不能为空，应该加密存储',
       email VARCHAR(255) NOT NULL UNIQUE COMMENT '邮箱，不能为空，且唯一',
       createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间，默认为当前时间'
) COMMENT = '存储用户基本信息的表';
CREATE TABLE file_table (
       id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，唯一标识每个文件',
       fileUrl VARCHAR(255) NOT NULL COMMENT '文件访问路径，不能为空',
       filename VARCHAR(255) NOT NULL COMMENT '文件名称，不能为空',
       fileCreateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '文件创建时间，默认为当前时间',
       viewCount INT DEFAULT 0 COMMENT '文件浏览计数，默认为 0'
) COMMENT = '存储文件信息的表';

