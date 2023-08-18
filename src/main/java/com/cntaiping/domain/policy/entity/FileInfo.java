package com.cntaiping.domain.policy.entity;

import com.cntaiping.infrastructure.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DynamicInsert
@DynamicUpdate
@Entity
@Comment(value = "文件信息表")
@Table(name = "t_file_info", schema = Constants.SCHEMA)
public class FileInfo  {

    @Id
    @Column(nullable = false)
    @Comment(value = "id")
    private UUID id;

    @Comment(value = "业务编号")
    @Column(name = "business_no", length = 50)
    private String bussinessNo;

    @Comment(value = "文件ID")
    @Column(length = 64)
    private String fileId;

    @Comment(value = "文件名")
    @Column(length = 128)
    private String fileName;

    @Comment(value = "文件原始名称")
    @Column(name = "file_name_origin", length = 128)
    private String fileNameOrgin;

    @Comment(value = "文件保存路径")
    @Column(length = 36)
    private String filePath;

}
