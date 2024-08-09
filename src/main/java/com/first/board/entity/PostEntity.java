package com.first.board.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POST")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    //@Column(name="user")
    private UserEntity user;

    @Column(name = "title")
    private String title;

    @Column(name = "p_content")
    private String content;

    @CreatedDate
    @Column(name = "post_createddate", updatable = false)
    private LocalDateTime post_createdDate;

    @LastModifiedDate
    @Column(name = "post_modifieddate")
    private LocalDateTime post_modifiedDate;

    @ColumnDefault("true")
    @Column(name="useFlag")
    private boolean useFlag;

    public PostEntity(Long postId, String title, String content, LocalDateTime post_createdDate, UserEntity user, boolean useFlag) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.post_createdDate = post_createdDate;
        this.user = user;
        this.useFlag = useFlag;
    }

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setUseFlag(boolean useFlag){
        this.useFlag = useFlag;
    }
}