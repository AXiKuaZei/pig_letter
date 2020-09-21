package indi.axikuazei.pigletter.service;


import indi.axikuazei.pigletter.dao.entity.Article;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

public interface ArticleService {
    List<Article> selectArticles();

    List<Article> selectArticlesPage(int id, int size);

    List<Article> selectArticlesPageUser(int id, int size, int user_id);

    void insertArticle(Article article);

    void deleteArticleByID(int id);

    Article selectArticleByID(int id);

    void updateArticle(Article article);

    int selectArticlesPageNum(int size);

    int selectArticlesPageNumUser(int size,int user_id);
}
