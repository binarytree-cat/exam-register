package cn.edu.examregister.service.serviceImpl;

import cn.edu.examregister.domain.User;
import cn.edu.examregister.mapper.UserMapper;
import cn.edu.examregister.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @author Binary cat
 * @date 2022/10/15 21:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
