package cn.edu.examregister.service.serviceImpl;

import cn.edu.examregister.domain.LoginUser;
import cn.edu.examregister.domain.User;
import cn.edu.examregister.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Binary cat
 * @date 2022/10/15 21:23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     *  在此处根据 username 去找密码，查看是否匹配
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername,username.trim());
        User user = userMapper.selectOne(userLambdaQueryWrapper);


        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        return new LoginUser(user);
    }
}
