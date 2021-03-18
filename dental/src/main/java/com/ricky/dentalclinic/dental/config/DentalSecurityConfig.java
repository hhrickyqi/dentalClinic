package com.ricky.dentalclinic.dental.config;


import com.ricky.dentalclinic.dental.service.UserService;
import com.ricky.dentalclinic.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class DentalSecurityConfig extends SecurityConfig {
    @Autowired
    private UserService userService;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/index.html",
                "swagger-ui/**"
        );
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> userService.loadUserByUsername(username);
    }
}
