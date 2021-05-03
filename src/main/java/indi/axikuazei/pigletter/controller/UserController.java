package indi.axikuazei.pigletter.controller;


import indi.axikuazei.pigletter.beans.ResultApi;
import indi.axikuazei.pigletter.dao.entity.UserTbl;
import indi.axikuazei.pigletter.service.UserService;
import indi.axikuazei.pigletter.utils.MDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@RestController
public class UserController {

    //private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @PostMapping("/user/logout")
    public ResultApi logout(HttpServletRequest req){
        req.getSession().removeAttribute("user");
        return ResultApi.newSuccessResult();
    }

    @PostMapping("/user/login")
    public ResultApi login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest req){
        List<UserTbl> users = userService.selectUserByName(username);
        if(users.size()!=1){
            return ResultApi.newFailResult();
        }else{
            UserTbl user = users.get(0);
            String pwd = MDUtils.sha256(password,user.getSalt());
            if(user.getPswd().equals(pwd)){
                req.getSession().setAttribute("user", user);
                return ResultApi.newSuccessResult();
            }else{
                return ResultApi.newFailResult();
            }
        }
    }

    @PostMapping("/user/register")
    public ResultApi register(@RequestBody UserTbl user){
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        user.setPswd(MDUtils.sha256(user.getPswd(),salt));
        int res = userService.insertNewUser(user);
        return res==1?ResultApi.newSuccessResult():ResultApi.newFailResult();
    }

    @GetMapping("user/exist/{username}")
    public  ResultApi exist(@PathVariable("username") String username){
        if(userService.existsUser(username)){
            return ResultApi.newFailResult();
        }else{
            return ResultApi.newSuccessResult();
        }
    }
}
