package github.kyrenesjtv.albertadmin;

import github.kyrenesjtv.albertadmin.config.security.JwtTokenUtil;
import github.kyrenesjtv.albertadmin.config.springcontext.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
<<<<<<< HEAD
=======
import org.springframework.context.ApplicationContext;
>>>>>>> 5be5ca1d72cb10dffdc86c7e455cadd7fd5729e2
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@EnableAsync
@ComponentScan
//能够扫描我们自己编写的servlet 和filter 用于driud监控
@ServletComponentScan
@SpringBootApplication
@ServletComponentScan
public class AlbertadminApplication {

    @Autowired
    private CorsConfigurationSource configSource;

    public static void main(String[] args) {
        SpringApplication.run(AlbertadminApplication.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    public CorsFilter CorsFilter() {
        return new CorsFilter(configSource);
    }


}
