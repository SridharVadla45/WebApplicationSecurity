package com.learn.security.login_register_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class CustomSecurityConfiguration {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) ->
                requests.
                         requestMatchers("employee/testAuth").authenticated()
                        .anyRequest().permitAll()
                                        );
        http.csrf(csrfConfig -> csrfConfig.disable());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }



    @Bean
    PasswordEncoder customPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
