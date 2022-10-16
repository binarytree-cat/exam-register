package cn.edu.examregister.service;

import cn.edu.examregister.domain.ResponseResult;
import cn.edu.examregister.domain.User;

/**
 * @author Binary cat
 * @date 2022/10/16 9:26
 */
public interface LoginService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    public ResponseResult login(User user);

    /**
     * 用户退出
     * @return
     */
    public ResponseResult logout();
}
