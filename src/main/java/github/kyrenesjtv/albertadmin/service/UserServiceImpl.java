package github.kyrenesjtv.albertadmin.service;


import github.kyrenesjtv.albertadmin.dao.UserMapper;
import github.kyrenesjtv.albertadmin.entity.po.GlobalUser;
import github.kyrenesjtv.albertadmin.entity.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/22 17:10
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public GlobalUser getUserByName(String username) {
        return userMapper.getUserByName(username);
    }
}
