package com.first.board.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMMENT")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(name="content")
    private String content;

    @CreatedDate
    @Column(name = "createdDate", updatable=false)
    private LocalDateTime createdDate;

    public void update (String content) {
        this.content = content;
    }

    public CommentEntity(Long commentId, PostEntity postId, String content, LocalDateTime createdDate, UserEntity user) {
        this.commentId = commentId;
        this.postId = postId;
        this.content = content;
        this.createdDate = createdDate;
        this.userId = user;
    }
}

