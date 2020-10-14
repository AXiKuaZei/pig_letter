package indi.axikuazei.pigletter.controller;


import indi.axikuazei.pigletter.beans.ResultApi;
import indi.axikuazei.pigletter.dao.entity.Article;
import indi.axikuazei.pigletter.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@RestController
public class ArticleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;


    @PostMapping("/article")
    public ResultApi add(Article article){
        articleService.insertArticle(article);
        return ResultApi.newSuccessResult();
    }

    @PutMapping("/article")
    public ResultApi update(Article article){
        articleService.updateArticle(article);
        return ResultApi.newSuccessResult();
    }

    @GetMapping("/article")
    public ResultApi show(@RequestParam(value = "apg",defaultValue="1") int apg, @RequestParam(value = "size",defaultValue="5") int size){
        logger.info("select article at page:"+apg+"and size:"+size);
        Map<String, Object> resMap = new HashMap<>();
        int apages =  articleService.selectArticlesPageNum(size);
        apg = apg>apages?apages:apg;
        apg = apg<1?1:apg;
        List<Article> articles = articleService.selectArticlesPage(size*(apg-1),size);
        resMap.put("articles", articles);
        resMap.put("apages", apages);
        resMap.put("apg", apg);
        return ResultApi.newSuccessResult(resMap);
    }

    @DeleteMapping("/article")
    public ResultApi delete(@RequestBody int articleId){
        logger.info("delete article:"+articleId);
        articleService.deleteArticleByID(articleId);
        return ResultApi.newSuccessResult();
    }


    @DeleteMapping("/articleMulti")
    public ResultApi delete(@RequestBody Integer[] articleId){
        for(Integer i:articleId){
            articleService.deleteArticleByID(i);
        }
        return ResultApi.newSuccessResult();
    }

}
