package github.kyrenesjtv.albertadmin.controller.anonymousController;

import github.kyrenesjtv.albertadmin.config.annotation.AnonymousAccess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2020/8/28 16:09
 */
@RequestMapping(value = "/auth")
@RestController
public class AuthorizationController {


    @PostMapping(value = "/login")
    @AnonymousAccess
    public void userLogin(){

    }


}
