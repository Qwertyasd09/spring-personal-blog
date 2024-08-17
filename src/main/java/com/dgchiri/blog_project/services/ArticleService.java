package com.dgchiri.blog_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgchiri.blog_project.models.Article;
import com.dgchiri.blog_project.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public Article findArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article with ID: " + id + " not found."));
    }

    public void createArticle(Article newArticle) {
        articleRepository.save(newArticle);
    }

    public void updateArticle(Long articleId, Article newInfoArticle) {
        Article articleToUpdate = findArticleById(articleId);
        articleToUpdate.setArticleName(newInfoArticle.getArticleName());
        articleToUpdate.setCreatedAt(newInfoArticle.getOriginalCreatedAt());
        articleToUpdate.setArticleDescription(newInfoArticle.getArticleDescription());
        articleRepository.save(articleToUpdate);
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }

}
