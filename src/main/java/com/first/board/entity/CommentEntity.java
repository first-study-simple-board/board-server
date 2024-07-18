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
    private Long comment_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", table = "POST")
    private PostEntity postEntity;

    @Column(name="content")
    private String content;

    @CreatedDate
    @Column(name = "createdDate", updatable=false)
    private LocalDateTime createdDate;

    public CommentEntity (Long id, String content, LocalDateTime createdDate, PostEntity postEntity) {
        this.comment_id = id;
        this.postEntity = postEntity;
        this.content = content;
        this.createdDate = createdDate;
    }
}

