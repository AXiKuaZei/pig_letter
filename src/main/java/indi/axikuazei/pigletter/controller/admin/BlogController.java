package indi.axikuazei.pigletter.controller.admin;

import indi.axikuazei.pigletter.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author axikuazei
 * @date 2020/9/18 上午11:29
 */
public class BlogController {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;


}
