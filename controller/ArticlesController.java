package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.Articles;
import com.peter.smartmedicalserver.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/science/articles")
    public List<Articles> getArticles() {
        return articlesService.getArticles();
    }

    @GetMapping("/psychology/articles/{id}")
    public Articles getArticleById(@PathVariable("id") int id) {
        return articlesService.getArticleById(id);
    }

    @GetMapping("/admin/articles")
    public List<Articles> selectArticles() {
        return articlesService.selectArticles();
    }

    @PostMapping("/admin/articles")
    public void insertArticle(@RequestBody Articles articles) {
        articlesService.insertArticle(articles);
    }

    @PutMapping("/admin/articles/{id}")
    public String updateArticles(@PathVariable int id, @RequestBody Articles articles) {
        int result = articlesService.updateArticles(articles, id);
        if (result > 0) {
            return "文章更新成功";
        } else {
            return "文章更新失败";
        }
    }

    @DeleteMapping("/admin/articles/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable int id) {
        boolean deleted = articlesService.deleteArticles(id);
        if (deleted) {
            return ResponseEntity.ok("Article deleted successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to delete article");
        }
    }

    @GetMapping("/psychology/hot")
    public List<Articles> getHotArticles() {
        return articlesService.getHotArticles();
    }
    @GetMapping("/psychology/marriage")
    public List<Articles> getMarriageArticles() {
        return articlesService.getMarriageArticles();
    }

    @GetMapping("/psychology/family")
    public List<Articles> getFamilyArticles() {
        return articlesService.getFamilyArticles();
    }

    @GetMapping("/psychology/social")
    public List<Articles> getSocialArticles() {
        return articlesService.getSocialArticles();
    }
    @GetMapping("/psychology/self-awareness")
    public List<Articles> getSelfAwarenessArticles() {
        return articlesService.getSelfAwarenessArticles();
    }
}
