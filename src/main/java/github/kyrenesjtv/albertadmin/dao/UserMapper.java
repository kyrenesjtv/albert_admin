package github.kyrenesjtv.albertadmin.dao;

import github.kyrenesjtv.albertadmin.entity.po.GlobalUser;
import github.kyrenesjtv.albertadmin.entity.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/22 17:30
 */
@Repository
public interface UserMapper {


    GlobalUser getUserByName(@Param("name") String username);
}
