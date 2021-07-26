package github.kyrenesjtv.albertadmin.controller;

import github.kyrenesjtv.albertadmin.config.annotation.AnonymousAccess;
import github.kyrenesjtv.albertadmin.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @AnonymousAccess
    public Map<String,Object> test() throws Exception{
        Map<String, Object> userById = testService.getUserById();
        return userById;
    }

}
