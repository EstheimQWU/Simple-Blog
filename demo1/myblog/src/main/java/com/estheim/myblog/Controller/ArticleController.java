package com.estheim.myblog.Controller;

import com.estheim.myblog.Entity.Article;
import com.estheim.myblog.Mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Article")
public class ArticleController {

    @Autowired // 自动装配Bean注解
    private ArticleMapper articleMapper;

    // 测试
    @PostMapping("/hello")
    public String testHello(){
        return "hello";
    }

    // 测试article数据获取
    @PostMapping("/article")
    public Article testHello(@ModelAttribute("article_id")String article_id){
        Article article;
        article=articleMapper.getArticle(Integer.parseInt(article_id));
        return article;
    }
}
