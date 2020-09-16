package github.kyrenesjtv.albertadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@EnableAsync
@SpringBootApplication
public class AlbertadminApplication {

    @Autowired
    private CorsConfigurationSource configSource;

    public static void main(String[] args) {
        SpringApplication.run(AlbertadminApplication.class, args);
    }

    @Bean
    public CorsFilter CorsFilter() {
        return new CorsFilter(configSource);
    }


}
