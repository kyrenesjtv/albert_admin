package github.kyrenesjtv.albertadmin.entity.dao;

import github.kyrenesjtv.albertadmin.entity.po.UserPO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/26 16:34
 */
public class JwtUserDto implements UserDetails {

    private UserPO user;

    private  List<GrantedAuthority> authorities;


    public JwtUserDto(UserPO userPO, List<GrantedAuthority> authorities) {
        this.user = userPO;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
