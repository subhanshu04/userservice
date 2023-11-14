package dev.nikhil.userservicetestfinal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {
    // --- Client-----Spring Security----- Controller

    @Bean
    public SecurityFilterChain filteringCriteria(HttpSecurity http) throws Exception {
        http.cors().disable();
        http.csrf().disable();
        http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
        return http.build();
    }

    // Role Service which two different DB Production and Staging
    /*
    @Bean("RoleServiceProd")
    public RoleService roleService(){
        return new RoleService(PROD DB Credentials);
    }
    @Bean("RoleServiceStag")
    public RoleService roleService(){
        return new RoleService(Stag DB Credentials);
    }
     */

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
