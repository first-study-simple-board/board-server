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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_ID")
    private PostEntity post_ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    private UserEntity user_ID;

    private String content;

    @CreatedDate
    @Column(updatable=false)
    private LocalDateTime createdDate;

    public CommentEntity (Long id, String content, LocalDateTime createdDate, UserEntity user_ID, PostEntity post_ID) {
        this.id = id;
        this.post_ID = post_ID;
        this.user_ID = user_ID;
        this.content = content;
        this.createdDate = createdDate;
    }

    
}

