package github.kyrenesjtv.albertadmin.service;

import github.kyrenesjtv.albertadmin.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @ProjectName: albert_admin
 * @Author: AlbertW
 * @CreateDate: 2020/9/16 19:16
 */
@Service
@Transactional(value = "mysqlTransactionManager")
public class TestServiceImpl implements ITestService{

    @Autowired
    private TestDao testDao;

    @Override
    public Map<String, Object> getUserById() {
        Map<String, Object> map = testDao.getUserById();
        return map;
    }
}
