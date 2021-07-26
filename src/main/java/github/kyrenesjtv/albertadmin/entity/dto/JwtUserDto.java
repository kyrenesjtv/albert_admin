package github.kyrenesjtv.albertadmin.entity.dto;

import github.kyrenesjtv.albertadmin.entity.po.GlobalUser;
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

    private GlobalUser user;


    private  List<GrantedAuthority> authorities;


    public JwtUserDto(GlobalUser userPO, List<GrantedAuthority> authorities) {
        this.user = userPO;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void removePassword(){
        this.user.setPassword("******");
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLoginName();
    }

    //不过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //不锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //凭证没有过去
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //是激活
    @Override
    public boolean isEnabled() {
        return user.getState()==null?false:user.getState()==1?true:false;
//        return true;
    }
}
