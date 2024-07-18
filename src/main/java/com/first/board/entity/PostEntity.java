package com.first.board.entity;

import java.time.LocalDateTime;

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
    private Long post_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user_id;

    @Column(name = "title")
    private String title;

    @Column(name = "p_content")
    private String p_Content;

    @CreatedDate
    @Column(name = "createdDate",updatable=false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name="modifiedDate")
    private LocalDateTime modifiedDate;

    public PostEntity (Long id, String title, String p_content, LocalDateTime createdDate, UserEntity userEntity) {
        this.post_id = id;
        this.user_id = userEntity;
        this.title = title;
        this.p_Content = p_content;
        this.createdDate = createdDate;
    }

    public void update (String title, String p_Content) {
        this.title = title;
        this.p_Content = p_Content;
    }
}