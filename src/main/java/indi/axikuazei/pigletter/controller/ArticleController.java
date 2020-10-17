package indi.axikuazei.pigletter.controller;


import com.github.pagehelper.PageInfo;
import indi.axikuazei.pigletter.beans.ResultApi;
import indi.axikuazei.pigletter.dao.entity.ArticleTbl;
import indi.axikuazei.pigletter.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@RestController
public class ArticleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;


    @GetMapping("/article")
    public ResultApi show(@RequestParam(value = "pageNum",defaultValue="1") int pageNum, @RequestParam(value = "pageSize",defaultValue="5") int pageSize){
        logger.info("select article at page:"+pageNum+" and size:"+pageSize);
        PageInfo pageInfo = articleService.selectArticlesByPage(pageNum, pageSize);
        return ResultApi.newSuccessResult(pageInfo);
    }

    @PostMapping("/article")
    public ResultApi add(ArticleTbl article){
        articleService.insertArticle(article);
        return ResultApi.newSuccessResult();
    }

    @PutMapping("/article")
    public ResultApi update(ArticleTbl article){
        articleService.updateArticle(article);
        return ResultApi.newSuccessResult();
    }

    @DeleteMapping("/article")
    public ResultApi delete(@RequestBody int articleId){
        logger.info("delete article:"+articleId);
        int res = articleService.deleteArticleByID(articleId);
        return res==1?ResultApi.newSuccessResult():ResultApi.newFailResult();
    }


    @DeleteMapping("/articleMulti")
    public ResultApi delete(@RequestBody Integer[] articleId){
        for(Integer i:articleId){
            if(articleService.deleteArticleByID(i)==0){
                return ResultApi.newFailResult();
            }
        }
        return ResultApi.newSuccessResult();
    }

}
