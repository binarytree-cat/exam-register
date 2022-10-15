package cn.edu.examregister.service.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Binary cat
 * @date 2022/10/15 21:23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    /**
     *  在此处根据 username 去找密码，查看是否匹配
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO

        return null;
    }
}
