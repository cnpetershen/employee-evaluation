package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.Articles;
import com.peter.smartmedicalserver.mapper.ArticlesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;
    public List<Articles> getArticles() {
        return articlesMapper.getArticles();
    }

    public Articles getArticleById(int id) {
        return articlesMapper.getArticleById(id);
    }

    public List<Articles> selectArticles() {
        return articlesMapper.selectArticles();
    }

    public List<Articles> getHotArticles() {
        return articlesMapper.getHotArticles();
    }

    public List<Articles> getFamilyArticles() {
        return articlesMapper.getFamilyArticles();
    }

    public List<Articles> getMarriageArticles() {
        return articlesMapper.getMarriageArticles();
    }

    public List<Articles> getSocialArticles() {
        return articlesMapper.getSocialArticles();
    }

    public List<Articles> getSelfAwarenessArticles() {
        return articlesMapper.getSelfAwarenessArticles();
    }

    public void insertArticle(Articles articles) {
        articlesMapper.insertArticle(articles);
    }

    public int updateArticles(Articles articles, int id) {
            return articlesMapper.updateArticles(articles, id);

    }

    public boolean deleteArticles(int id) {
        int result = articlesMapper.deleteArticles(id);
        return result > 0;
    }
}
