package github.kyrenesjtv.albertadmin.service;

import github.kyrenesjtv.albertadmin.entity.po.GlobalUser;
import github.kyrenesjtv.albertadmin.entity.po.UserPO;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/22 17:10
 */
public interface UserService {

    GlobalUser getUserByName(String username);
}
