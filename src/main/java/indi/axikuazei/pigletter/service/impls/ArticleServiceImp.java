package indi.axikuazei.pigletter.service.impls;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import indi.axikuazei.pigletter.dao.ArticleContentTblMapper;
import indi.axikuazei.pigletter.dao.ArticleTblMapper;
import indi.axikuazei.pigletter.dao.UserTblMapper;
import indi.axikuazei.pigletter.dao.entity.ArticleContentTbl;
import indi.axikuazei.pigletter.dao.entity.ArticleContentTblExample;
import indi.axikuazei.pigletter.dao.entity.ArticleTbl;
import indi.axikuazei.pigletter.dao.entity.ArticleTblExample;
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
    ArticleTblMapper articleTblMapper;

    @Autowired
    ArticleContentTblMapper articleContentTblMapper;

    @Autowired
    UserTblMapper userTblMapper;

    @Override
    public List<ArticleTbl> selectArticles(int offset, int num) {
        ArticleTblExample example = new ArticleTblExample();
        ArticleTblExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo((byte) 0);
        example.setOrderByClause("published_time DESC LIMIT "+offset+","+num);
        return selectAuthor(selectContent(articleTblMapper.selectByExample(example)));
    }

    @Override
    public PageInfo<ArticleTbl> selectArticlesByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleTblExample example = new ArticleTblExample();
        example.createCriteria().andDeletedEqualTo((byte) 0);
        example.setOrderByClause("published_time DESC");
        List<ArticleTbl> articles = articleTblMapper.selectByExample(example);
        PageInfo<ArticleTbl> pageInfo = new PageInfo<ArticleTbl>(selectAuthor(selectContent(articles)));
        return pageInfo;
    }

    @Override
    public PageInfo<ArticleTbl> selectArticlesByPageAndUser(int pageNum, int pageSize, int author_id) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleTblExample example = new ArticleTblExample();
        example.createCriteria().andDeletedEqualTo((byte) 0).andAuthorIdEqualTo(author_id);
        example.setOrderByClause("published_time DESC");
        List<ArticleTbl> articles = articleTblMapper.selectByExample(example);
        PageInfo<ArticleTbl> pageInfo = new PageInfo<ArticleTbl>(selectAuthor(selectContent(articles)));
        return pageInfo;
    }

    @Override
    public List<ArticleTbl> selectContent(List<ArticleTbl> articles) {
        for(ArticleTbl article:articles){
            ArticleContentTblExample cexample = new ArticleContentTblExample();
            cexample.createCriteria()
                    .andArticleIdEqualTo(article.getArticleId())
                    .andDeletedEqualTo((byte)0);
            List<ArticleContentTbl> contents= articleContentTblMapper.selectByExampleWithBLOBs(cexample);
            String content = contents.get(0).getContent();
            article.setContent(content);
        }
        return articles;
    }

    @Override
    public ArticleTbl selectContent(ArticleTbl article) {
        ArticleContentTblExample cexample = new ArticleContentTblExample();
        cexample.createCriteria()
                .andArticleIdEqualTo(article.getArticleId())
                .andDeletedEqualTo((byte)0);
        List<ArticleContentTbl> contents= articleContentTblMapper.selectByExampleWithBLOBs(cexample);
        String content = contents.get(0).getContent();
        article.setContent(content);
        return article;
    }

    @Override
    public List<ArticleTbl> selectAuthor(List<ArticleTbl> articles) {
        for(ArticleTbl article:articles){
            article.setAuthor(userTblMapper.selectByPrimaryKey(article.getAuthorId()).getNickName());
        }
        return articles;
    }

    @Override
    public int insertArticle(ArticleTbl article) {
        int res = 1;
        articleTblMapper.insertSelective(article);
        ArticleContentTbl acTbl = new ArticleContentTbl();
        acTbl.setContent(article.getContent());
        acTbl.setArticleId(article.getArticleId());
        articleContentTblMapper.insertSelective(acTbl);
        return res;
    }

    @Override
    public int deleteArticleByID(int id) {
        return  articleTblMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ArticleTbl selectArticleByID(int id) {
        ArticleTbl articleTbl = articleTblMapper.selectByPrimaryKey(id);
        return selectContent(articleTbl);
    }

    @Override
    public int updateArticle(ArticleTbl article) {
        int res = 1;
        articleTblMapper.updateByPrimaryKeySelective(article);
        ArticleContentTbl acTbl = new ArticleContentTbl();
        acTbl.setContent(article.getContent());
        ArticleContentTblExample example = new ArticleContentTblExample();
        example.createCriteria().andArticleIdEqualTo(article.getArticleId());
        articleContentTblMapper.updateByExampleSelective(acTbl,example);
        return res;
    }
}
