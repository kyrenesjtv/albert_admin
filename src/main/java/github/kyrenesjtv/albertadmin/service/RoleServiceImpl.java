package github.kyrenesjtv.albertadmin.service;

import github.kyrenesjtv.albertadmin.dao.RoleMapper;
import github.kyrenesjtv.albertadmin.entity.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/28 10:55
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<GrantedAuthority> getGrantedAuthorities(UserPO userPO) {
//        if(userPO.getIsAdmin() == 1 ){
            //超级管理员，默认所有权限
            List<GrantedAuthority> result = new ArrayList<>();
            result.add(new SimpleGrantedAuthority("admin"));
            return result;
//        }else{
//            //去获取权限数据
//            List<String> pers = roleMapper.getPermissionByUserId(userPO.getId());
//            return pers.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//        }
    }
}
