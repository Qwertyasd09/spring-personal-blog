package com.dgchiri.blog_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dgchiri.blog_project.models.Article;
import com.dgchiri.blog_project.services.ArticleService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    
    @Autowired
    ArticleService articleService;

    @GetMapping("/new")
    public String articleForm(Model model) {
        model.addAttribute("newArticle", new Article());
        return "admin/new";
    }

    @PostMapping("/new")
    public String articlePublish(@ModelAttribute Article newArticle) {
        articleService.createArticle(newArticle);
        return "redirect:/home";
    }

    @GetMapping("/edit/{articleId}")
    public String articleUpdateForm(@PathVariable Long articleId, Model model) {
        Article updatedArticle = articleService.findArticleById(articleId);
        model.addAttribute("updatedArticle", updatedArticle);
        return "admin/edit";
    }

    @PutMapping("/edit/{articleId}")
    public String articleUpdate(@PathVariable Long articleId, @ModelAttribute Article updatedArticle) {
        articleService.updateArticle(articleId, updatedArticle);
        return "redirect:/home";
    }

    @GetMapping("/admin")
    public String adminHome(@ModelAttribute Article adminArticle, Model model) {
        List<Article> articles = articleService.findAllArticles();
        model.addAttribute("articles", articles);
        return "admin/admin";
    }

    @GetMapping("/delete/{articleId}") 
    public String articleDelete(@PathVariable Long articleId, Model model) {
        Article deletedArticle = articleService.findArticleById(articleId);
        model.addAttribute("deletedArticle", deletedArticle);
        articleService.deleteArticle(articleId);
        return "admin/delete";
    }
    
}
