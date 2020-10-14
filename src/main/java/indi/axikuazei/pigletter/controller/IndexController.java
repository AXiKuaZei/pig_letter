package indi.axikuazei.pigletter.controller;


import indi.axikuazei.pigletter.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@RestController
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;

    @RequestMapping("index")
    public ModelAndView getconsole(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
