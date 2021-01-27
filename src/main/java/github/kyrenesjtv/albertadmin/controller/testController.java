package github.kyrenesjtv.albertadmin.controller;

import github.kyrenesjtv.albertadmin.config.annotation.AnonymousAccess;
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

    @RequestMapping(value = "/test")
    public Map<String,Object> test() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("name","albert");
        return map;
    }

}
