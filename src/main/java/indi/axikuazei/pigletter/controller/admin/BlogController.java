package indi.axikuazei.pigletter.controller.admin;


import indi.axikuazei.pigletter.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogController {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;


}
