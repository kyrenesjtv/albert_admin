package github.kyrenesjtv.albertadmin.controller;

<<<<<<< HEAD
import github.kyrenesjtv.albertadmin.config.annotation.AnonymousAccess;
import github.kyrenesjtv.albertadmin.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
=======
import github.kyrenesjtv.albertadmin.config.security.SecurityUtil;
import org.springframework.security.access.prepost.PreAuthorize;
>>>>>>> 5be5ca1d72cb10dffdc86c7e455cadd7fd5729e2
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2020/8/23 20:52
 */
@RequestMapping(value = "/test")
@RestController
public class testController {

    @Autowired
    private ITestService testService;

    @RequestMapping(value = "/test")
    @PreAuthorize("@aw.check('/test/test')")
    public Map<String,Object> test() throws Exception{
<<<<<<< HEAD
        Map<String, Object> userById = testService.getUserById();
        return userById;
=======

        Map<String, Object> map = new HashMap<>();
        map.put("name","albert");
        return map;
>>>>>>> 5be5ca1d72cb10dffdc86c7e455cadd7fd5729e2
    }

}
