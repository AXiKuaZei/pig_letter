package indi.axikuazei.pigletter.service;

import com.github.pagehelper.PageInfo;
import indi.axikuazei.pigletter.dao.entity.ArticleTbl;
import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

public interface ArticleService {
    List<ArticleTbl> selectArticles(int offset, int num);

    PageInfo<ArticleTbl> selectArticlesByPage(int pageNum, int pageSize);

    PageInfo<ArticleTbl> selectArticlesByPageAndUser(int pageNum, int pageSize, int authorId);

    List<ArticleTbl> selectContent(List<ArticleTbl> articles);

    ArticleTbl selectContent(ArticleTbl article);

    List<ArticleTbl> selectAuthor(List<ArticleTbl> articles);

    int insertArticle(ArticleTbl article);

    int deleteArticleByID(int id);

    ArticleTbl selectArticleByID(int id);

    int updateArticle(ArticleTbl article);
}
