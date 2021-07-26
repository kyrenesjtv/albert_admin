package github.kyrenesjtv.albertadmin.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @ProjectName: albert_admin
 * @Author: AlbertW
 * @CreateDate: 2020/9/16 19:17
 */
@Repository
public interface TestDao {

     Map<String,Object> getUserById();

}
