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

    @GetMapping("/article/{offset}/{num}")
    public ResultApi articles(@PathVariable("offset") int offset, @PathVariable("num") int num){
        logger.info("select articles at offset:"+offset+" and num:"+num);
        List<ArticleTbl> articles = articleService.selectArticles(offset, num);
        return ResultApi.newSuccessResult(articles);
    }

    @GetMapping("/article/{id}")
    public ResultApi articleById(@PathVariable("id") int id){
        logger.info("select article at id:"+id);
        ArticleTbl article = articleService.selectArticleByID(id);
        return ResultApi.newSuccessResult(article);
    }

    @PostMapping("/articlePage")
    public ResultApi articlePage(@RequestParam(value = "pageNum",defaultValue="1") int pageNum, @RequestParam(value = "pageSize",defaultValue="5") int pageSize){
        logger.info("select articles at page:"+pageNum+" and size:"+pageSize);
        PageInfo pageInfo = articleService.selectArticlesByPage(pageNum, pageSize);
        return ResultApi.newSuccessResult(pageInfo);
    }

    @PostMapping("/article")
    public ResultApi articleAdd(@RequestBody ArticleTbl article){
        articleService.insertArticle(article);
        return ResultApi.newSuccessResult();
    }

    @PutMapping("/article")
    public ResultApi articleUpdate(@RequestBody ArticleTbl article){
        articleService.updateArticle(article);
        return ResultApi.newSuccessResult();
    }

    @DeleteMapping("/article")
    public ResultApi articleDelete(@RequestParam("articleId") int articleId){
        logger.info("delete article:"+articleId);
        int res = articleService.deleteArticleByID(articleId);
        return res==1?ResultApi.newSuccessResult():ResultApi.newFailResult();
    }


    @DeleteMapping("/articleMulti")
    public ResultApi articleDelete(@RequestParam("articleIds") Integer[] articleIds){
        for(Integer i:articleIds){
            if(articleService.deleteArticleByID(i)==0){
                return ResultApi.newFailResult();
            }
        }
        return ResultApi.newSuccessResult();
    }

}
