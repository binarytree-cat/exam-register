package cn.edu.examregister.service.serviceImpl;

import cn.edu.examregister.domain.LoginUser;
import cn.edu.examregister.domain.ResponseResult;
import cn.edu.examregister.domain.User;
import cn.edu.examregister.service.LoginService;
import cn.edu.examregister.utils.JwtUtil;
import cn.edu.examregister.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Binary cat
 * @date 2022/10/16 9:27
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或者密码错误");
        }

        // 使用 user id 生成 token
        LoginUser loginUser =(LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        // 将 loginUser 存入 redis
        redisCache.setCacheObject("login:" + userId, loginUser);

        // 把 token 返回前端
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("token",jwt);

        return new ResponseResult<>(200,"登录成功",hashMap);
    }

    /**
     * 用户退出
     *
     * @return
     */
    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String usrId = loginUser.getUser().getId().toString();
        // 在 redis 删除其信息
        redisCache.deleteObject("login:" + usrId);
        return new ResponseResult<>(200, "退出登录成功！");
    }
}
