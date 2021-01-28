package github.kyrenesjtv.albertadmin.controller.anonymousController;

import github.kyrenesjtv.albertadmin.config.annotation.AnonymousAccess;
import github.kyrenesjtv.albertadmin.config.security.JwtTokenUtil;
import github.kyrenesjtv.albertadmin.entity.dto.JwtUserDto;
import github.kyrenesjtv.albertadmin.entity.dto.LoginUserDto;
import github.kyrenesjtv.albertadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.validation.annotation.Validated;
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
    public Map<String,Object> userLogin(HttpServletRequest request, @Validated @RequestBody LoginUserDto loginUser){
        Map<String,Object> result = new HashMap<>();
        //登录关键步骤，授权
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser.getLoginname(),loginUser.getPassword());
        authenticationToken.setDetails(new WebAuthenticationDetails(request));
            Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        JwtUserDto jwtUserDto = (JwtUserDto) authenticate.getPrincipal();
                String s = jwtTokenUtil.generateToken(jwtUserDto);
        result.put("token",jwtTokenUtil.getTokenStartWith()+ s);
        result.put("user",jwtUserDto);
        return result;
    }


}
