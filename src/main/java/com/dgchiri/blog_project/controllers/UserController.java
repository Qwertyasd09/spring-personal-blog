package com.dgchiri.blog_project.controllers;

import com.dgchiri.blog_project.models.Article;
import com.dgchiri.blog_project.services.ArticleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/home")
    public String homeView(Model model) {
        List<Article> articles = articleService.findAllArticles();
        model.addAttribute("articles", articles);
        return "users/home";
    }

    @GetMapping("/article/{articleId}")
    public String getMethodName(Model model, @PathVariable Long articleId) {
        Article currentArticle = articleService.findArticleById(articleId);
        model.addAttribute("currentArticle", currentArticle);
        return "users/article";
    }

}
