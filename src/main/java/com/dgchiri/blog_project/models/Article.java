package com.dgchiri.blog_project.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(nullable = false, length = 20)
    private String articleName;

    @Column(nullable = false, length = 500)
    private String articleDescription;

    @Column(name = "created_at")
    private String createdAt;

    public Article() { }

    public Article(Long articleId, String articleName, String articleDescription) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleDescription = articleDescription;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        LocalDate date = LocalDate.parse(createdAt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
        String formattedDate = date.format(formatter);
        this.createdAt = formattedDate;
    }

    public String getOriginalCreatedAt() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(createdAt, inputFormatter);
        return date.format(outputFormatter);
    }

}
