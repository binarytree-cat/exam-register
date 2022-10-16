package cn.edu.examregister.controller;

import cn.edu.examregister.domain.ResponseResult;
import cn.edu.examregister.domain.User;
import cn.edu.examregister.service.LoginService;
import cn.edu.examregister.service.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary cat
 * @date 2022/10/15 21:46
 */
@RestController()
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }
}
