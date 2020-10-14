package indi.axikuazei.pigletter.controller;


import indi.axikuazei.pigletter.dao.entity.Leetcode;
import indi.axikuazei.pigletter.service.LeetcodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@RestController
public class LeetcodeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LeetcodeService leetcodeService;


    @GetMapping("/leetcode")
    public ModelAndView showleetcode(@RequestParam(value = "lpg",defaultValue="1") int lpg,
                                     @RequestParam(value = "size",defaultValue="5") int size){
        ModelAndView mv = new ModelAndView("leetcodes");
        Map<String, Object> resMap = new HashMap<>();
        int lpages = leetcodeService.selectLeetcodesPageNum(size);
        lpg = lpg>lpages?lpages:lpg;
        lpg = lpg<1?1:lpg;
        resMap.put("lpages", lpages);
        resMap.put("leetcodes", leetcodeService.selectLeetcodesPage(size*(lpg-1),size));
        resMap.put("lpg", lpg);
        return mv;
    }

    @PutMapping("/leetcode")
    public ModelAndView updateleetcode(Leetcode leetcode){
        ModelAndView mv = new ModelAndView("redirect:/leetcode");
        leetcodeService.updateLeetcode(leetcode);
        return mv;
    }

    @PostMapping("/leetcode")
    public ModelAndView addleetcode(Leetcode leetcode){
        ModelAndView mv = new ModelAndView("redirect:/leetcode");
        leetcodeService.insertLeetcode(leetcode);
        return mv;
    }

    @DeleteMapping("/leetcode")
    public String deleteleetcode(int leetcode_id){
        leetcodeService.deleteLeetcodeByID(leetcode_id);
        return "redirect:/admin/console";
    }

    //========================================================================
    //page-ajax-leetcodes

    @ResponseBody
    @RequestMapping("/ooo")
    public List<Leetcode> getleetcodes(@RequestParam(value = "lpg",defaultValue="1") int lpg, HttpServletRequest req){
        List<Leetcode> leetcodes= leetcodeService.selectLeetcodesPage(5*(lpg-1),5);
        req.setAttribute("lpg",lpg);
        return leetcodes;
    }

    @ResponseBody
    @DeleteMapping("/leetcodeMulti")
    public List<Leetcode> delete(@RequestBody Integer[] article_id, HttpServletRequest req){

        for(Integer i:article_id){
            leetcodeService.deleteLeetcodeByID(i);
        }
        List<Leetcode> leetcodes= leetcodeService.selectLeetcodesPage(0,5);
        req.setAttribute("lpg",1);
        return leetcodes;
    }
}
