package cn.edu.examregister.controller;

import cn.edu.examregister.domain.ResponseResult;
import cn.edu.examregister.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binary cat
 * @date 2022/10/15 21:46
 */
@RestController()
public class LoginController {

    public ResponseResult login(@RequestBody User user){
        return null;
    }
}
