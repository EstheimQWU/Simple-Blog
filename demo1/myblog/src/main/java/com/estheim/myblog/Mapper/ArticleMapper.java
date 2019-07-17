package com.estheim.myblog.Mapper;

import com.estheim.myblog.Entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Article getArticle(int article_id);
}
