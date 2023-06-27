package com.crud.employee_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails John = User.builder().username("john").password("{noop}john123").roles("EMPLOYEE").build();

        UserDetails Mary = User.builder().username("mary").password("{noop}mary123").roles("EMPLOYEE","MANAGER").build();

        UserDetails Suse = User.builder().username("suse").password("{noop}suse123").roles("EMPLOYEE","ADMIN").build();

        return new InMemoryUserDetailsManager(John,Mary,Suse);
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
            configure.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
        //Use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable cross site request forgery
        //in general, not required for stateless REST APIs
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
