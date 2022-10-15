package cn.edu.examregister;

import cn.edu.examregister.domain.User;
import cn.edu.examregister.mapper.UserMapper;
import cn.edu.examregister.service.serviceImpl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ExamregisterApplicationTests {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public UserServiceImpl userService;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId,1);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        System.out.println(user);

        List<User> list = userService.list();
        System.out.println(list);
    }

}
