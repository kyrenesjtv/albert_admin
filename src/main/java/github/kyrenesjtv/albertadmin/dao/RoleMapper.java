package github.kyrenesjtv.albertadmin.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/28 13:38
 */
@Repository
public interface RoleMapper {

    List<String> getPermissionByUserId(Long id);
}
