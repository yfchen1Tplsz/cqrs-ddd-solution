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

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DynamicInsert
@DynamicUpdate
@Entity
@Comment(value = "批注表")
@Table(name = "t_comment", schema = Constants.SCHEMA)
public class CommentInfo {

    @Id
    @Comment(value = "id")
    @Column(nullable = false)
    private UUID id;

    @Comment(value = "保单id")
    @Column(nullable = false)
    private UUID policyId;

    @Comment(value = "当事人id")
    @Column
    private UUID partyId;

    @Comment(value = "批注生成日期")
    @Column(name = "comment_date")
    private LocalDateTime annotationDate;

    @Comment(value = "批注生成用户")
    @Column(name = "user_id", length = 50)
    private String annotationUser;

    @Comment(value = "批注内容")
    @Column(name = "comment_content", columnDefinition = "text")
    private String annotationContent;

    @Comment(value = "是否暂存标识")
    @Column(name = "save_ind", nullable = false,columnDefinition = "varchar(1) default 'F'")
    private String saveFlag;

}
