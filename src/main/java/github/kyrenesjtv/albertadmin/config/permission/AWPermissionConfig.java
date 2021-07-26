package github.kyrenesjtv.albertadmin.config.permission;

import github.kyrenesjtv.albertadmin.config.security.SecurityUtil;
import github.kyrenesjtv.albertadmin.config.springcontext.SpringContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/27 16:21
 */
@Service(value = "aw")
public class AWPermissionConfig {
    public Boolean check(String ...permissions){
        // 获取当前用户的所有权限
        UserDetails userDetails = SecurityUtil.getCurrentUser();
        List<String> collect = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());


        // 判断当前用户的所有权限是否包含接口上定义的权限
        return collect.contains("admin") || Arrays.stream(permissions).anyMatch(collect::contains);
    }
}
