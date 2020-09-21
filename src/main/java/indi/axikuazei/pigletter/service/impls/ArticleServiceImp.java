package indi.axikuazei.pigletter.service.impls;


import indi.axikuazei.pigletter.dao.ArticleMapper;
import indi.axikuazei.pigletter.dao.entity.Article;
import indi.axikuazei.pigletter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

@Transactional
@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;


    @Override
    public List<Article> selectArticles() {
        return articleMapper.selectArticles();
    }

    @Override
    public List<Article> selectArticlesPage(int id, int size) {
        return articleMapper.selectArticlesPage(id,size);
    }

    @Override
    public List<Article> selectArticlesPageUser(int id, int size, int user_id) {
        return articleMapper.selectArticlesPageUser(id,size,user_id);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public void deleteArticleByID(int id) {
        articleMapper.deleteArticleByID(id);
    }

    @Override
    public Article selectArticleByID(int id) { return articleMapper.selectArticleByID(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Override
    public int selectArticlesPageNum(int size) {
        int page=(int)Math.ceil(articleMapper.selectArticlesPageNum()/(float)size);
        return page>0?page:1;
    }

    @Override
    public int selectArticlesPageNumUser(int size, int user_id) {
        int page=(int)Math.ceil(articleMapper.selectArticlesPageNumUser(user_id)/(float)size);
        return page>0?page:1;
    }
}
