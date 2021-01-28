package github.kyrenesjtv.albertadmin.service;

import github.kyrenesjtv.albertadmin.entity.po.UserPO;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/28 10:54
 */
public interface RoleService {

    /**
     * 获取用户权限数据
     * @param userPO
     * @return
     */
    List<GrantedAuthority> getGrantedAuthorities(UserPO userPO);
}
