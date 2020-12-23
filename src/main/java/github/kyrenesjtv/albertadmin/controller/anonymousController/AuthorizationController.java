package github.kyrenesjtv.albertadmin.controller.anonymousController;

import github.kyrenesjtv.albertadmin.config.annotation.AnonymousAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2020/8/28 16:09
 */
@RequestMapping(value = "/auth")
@RestController
public class AuthorizationController {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;


    @PostMapping(value = "/login")
    @AnonymousAccess
    public void userLogin(HttpServletRequest request){

        String username = "username";
        String password = "password";
        //登录关键步骤，授权
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        authenticationToken.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }


}
