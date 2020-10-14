package indi.axikuazei.pigletter.dao;


import indi.axikuazei.pigletter.dao.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@Mapper
public interface ArticleMapper {

    List<Article> selectArticles();

    void insertArticle(Article article);

    void deleteArticleByID(int id);

    Article selectArticleByID(int id);

    void updateArticle(Article article);

    List<Article> selectArticlesPage(@Param("id") int id, @Param("size") int size);

    List<Article> selectArticlesPageUser(@Param("id") int id, @Param("size") int size, @Param("user_id") int user_id);

    int selectArticlesPageNum();

    int selectArticlesPageNumUser(@Param("user_id") int user_id);
}
