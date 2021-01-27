package github.kyrenesjtv.albertadmin.controller.anonymousController;

import github.kyrenesjtv.albertadmin.config.annotation.AnonymousAccess;
import github.kyrenesjtv.albertadmin.config.security.JwtTokenUtil;
import github.kyrenesjtv.albertadmin.entity.po.UserPO;
import github.kyrenesjtv.albertadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping(value = "/login")
    @AnonymousAccess
    public Map<String,Object> userLogin(HttpServletRequest request, @RequestBody UserPO userPO2){
        Map<String,Object> result = new HashMap<>();
        String username = userPO2.getLoginName();
        String password2 = userPO2.getPassword();
        UserPO userPO = userService.getUserByName(username);
        //登录关键步骤，授权
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,"123456");
        authenticationToken.setDetails(new WebAuthenticationDetails(request));
            Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String s = jwtTokenUtil.generateToken(userPO);
        result.put("token",s);
        result.put("user",userPO);
        return result;
    }


}
