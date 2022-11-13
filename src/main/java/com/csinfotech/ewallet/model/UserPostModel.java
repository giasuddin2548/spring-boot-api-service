package com.csinfotech.ewallet.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tbl_posts")
public class UserPostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private Long postByUserId;
    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Body is required")
    private String body;
    private String date;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private Date updatedAt;


    public UserPostModel() {
    }

    public UserPostModel(Long postByUserId, String title, String body, String date) {
        this.postByUserId = postByUserId;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPostByUserId() {
        return postByUserId;
    }

    public void setPostByUserId(Long postByUserId) {
        this.postByUserId = postByUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
