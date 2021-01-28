package github.kyrenesjtv.albertadmin.config.security;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/27 10:05
 */
public class TokenFilter extends GenericFilterBean {
    private final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);
    private final JwtTokenUtil jwtTokenUtil;

    public TokenFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = jwtTokenUtil.getToken(httpServletRequest);
        // 对于 Token 为空的不需要去查 Redis
        if (StrUtil.isNotBlank(token)) {
            //判断有没有过期
            Boolean aBoolean = jwtTokenUtil.validateToken(token);
            if(aBoolean){
                if (StringUtils.hasText(token)) {
                    Authentication authentication = jwtTokenUtil.getAuthentication(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    // Token 续期
                    jwtTokenUtil.refreshToken(token);
                }
            }else {
                //过期
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
