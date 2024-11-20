package com.smg.module.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 存储文件信息的表
 * @TableName file_table
 */
@TableName(value ="file_table")
@Data
public class FileTable implements Serializable {
    /**
     * 主键，唯一标识每个文件
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件访问路径，不能为空
     */
    @TableField(value = "fileUrl")
    private String fileUrl;

    /**
     * 文件名称，不能为空
     */
    @TableField(value = "filename")
    private String filename;

    /**
     * 文件创建时间，默认为当前时间
     */
    @TableField(value = "fileCreateTime")
    private Date fileCreateTime;

    /**
     * 文件浏览计数，默认为 0
     */
    @TableField(value = "viewCount")
    private Integer viewCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FileTable other = (FileTable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
            && (this.getFileCreateTime() == null ? other.getFileCreateTime() == null : this.getFileCreateTime().equals(other.getFileCreateTime()))
            && (this.getViewCount() == null ? other.getViewCount() == null : this.getViewCount().equals(other.getViewCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getFileCreateTime() == null) ? 0 : getFileCreateTime().hashCode());
        result = prime * result + ((getViewCount() == null) ? 0 : getViewCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", filename=").append(filename);
        sb.append(", fileCreateTime=").append(fileCreateTime);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}