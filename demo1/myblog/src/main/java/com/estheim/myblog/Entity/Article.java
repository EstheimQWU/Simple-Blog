package com.estheim.myblog.Entity;

public class Article {
    private int article_id;
    private String article_title;
    private String article_author;
    private String article_content;

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_title='" + article_title + '\'' +
                ", article_author='" + article_author + '\'' +
                ", article_content='" + article_content + '\'' +
                '}';
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Article(int article_id, String article_title, String article_author, String article_content) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_author = article_author;
        this.article_content = article_content;
    }
}
