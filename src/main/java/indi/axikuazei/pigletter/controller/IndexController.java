package indi.axikuazei.pigletter.controller;


import indi.axikuazei.pigletter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    @RequestMapping({"/","index"})
    public ModelAndView getconsole(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("articles",articleService.selectArticlesPage(0,7));
        return mv;
    }
}
