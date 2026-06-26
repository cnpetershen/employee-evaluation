package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.Articles;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface ArticlesMapper {

    @Select("SELECT id,title FROM articles limit 5")
    List<Articles> getArticles();

@Select("SELECT id,title,content FROM articles WHERE id = #{id}")
    Articles getArticleById(int id);
@Select("SELECT id,title,author,category,date FROM articles")
    List<Articles> selectArticles();

@Select("SELECT id,title,content FROM articles WHERE category = 'hot' ")
    List<Articles> getHotArticles();

@Select("SELECT id,title,content FROM articles WHERE category = 'family' ")
    List<Articles> getFamilyArticles();
@Select("SELECT id,title,content FROM articles WHERE category = 'marriage'")
    List<Articles> getMarriageArticles();
@Select("SELECT id,title,content FROM articles WHERE category = 'social'")
    List<Articles> getSocialArticles();
@Select("SELECT id,title,content FROM articles WHERE category = 'self-awareness' ")
    List<Articles> getSelfAwarenessArticles();
@Insert("INSERT INTO articles(title,content,author,category,date) VALUES(#{title},#{content},#{author},#{category},#{date})")
    void insertArticle(Articles articles);
@Update("UPDATE articles SET title = #{articles.title}, content = #{articles.content}, author = #{articles.author}, date = #{articles.date}, category = #{articles.category} WHERE id = #{id}")
    int updateArticles(@Param("articles") Articles articles, @Param("id") int id);
@Delete("DELETE FROM articles WHERE id = #{id}")
    int deleteArticles(int id);
}
