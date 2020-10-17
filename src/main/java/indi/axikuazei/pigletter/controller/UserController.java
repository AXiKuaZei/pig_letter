package indi.axikuazei.pigletter.controller;


import indi.axikuazei.pigletter.beans.ResultApi;
import indi.axikuazei.pigletter.dao.entity.UserTbl;
import indi.axikuazei.pigletter.service.UserService;
import indi.axikuazei.pigletter.utils.MDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().removeAttribute("user");
        return "redirect:/index";
    }

    @PostMapping("/login")
    public ResultApi login(String userName, String password, HttpServletRequest req){
        List<UserTbl> users = userService.selectUserByName(userName);
        if(users.size()!=1){
            return ResultApi.newFailResult();
        }else{
            UserTbl user = users.get(0);
            String pwd = MDUtils.Sha256(password);
            if(user.getPswd().equals(pwd)){
                req.getSession().setAttribute("user", user);
                return ResultApi.newSuccessResult();
            }else{
                return ResultApi.newFailResult();
            }
        }
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public ResultApi register(String userName, String password, String nickName){
        UserTbl user = new UserTbl();
        user.setUserName(userName);
        user.setPswd(MDUtils.Sha256(password));
        user.setNickName(nickName);
        int res = userService.insertNewUser(user);
        return res==1?ResultApi.newSuccessResult():ResultApi.newFailResult();
    }

    @RequestMapping("/personalCenter")
    public String personCenter(){
        return "admin/personalCenter";
    }
}
