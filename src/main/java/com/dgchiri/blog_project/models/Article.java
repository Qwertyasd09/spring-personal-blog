package com.dgchiri.blog_project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(nullable = false, length = 20)
    private String articleName;

    @Column(nullable = false)
    private String articleDescription;

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


    



}
