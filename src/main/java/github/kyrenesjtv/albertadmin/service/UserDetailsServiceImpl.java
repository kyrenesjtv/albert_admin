package github.kyrenesjtv.albertadmin.service;

import github.kyrenesjtv.albertadmin.config.exception.EntityNotFoundException;
import github.kyrenesjtv.albertadmin.entity.dao.JwtUserDto;
import github.kyrenesjtv.albertadmin.entity.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/26 16:08
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPO userPO = null;
        try {
            userPO = userService.getUserByName(username);
        } catch (EntityNotFoundException e) {
            // SpringSecurity会自动转换UsernameNotFoundException为BadCredentialsException
            throw new UsernameNotFoundException("", e);
        }
        if (userPO == null) {
            throw new UsernameNotFoundException("");
        } else {
            List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("超级管理员"));
            return new User(userPO.getLoginName(), userPO.getPassword(), authorities);
        }

    }
}
