package spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by DYY on 2016/8/12.
 */
@Configuration
@EnableWebMvc
@ComponentScan("spring")
public class AppConfig {

}
