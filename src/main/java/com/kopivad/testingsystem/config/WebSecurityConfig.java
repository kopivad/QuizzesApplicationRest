package com.kopivad.testingsystem.config;

import com.kopivad.testingsystem.domain.Role;
import com.kopivad.testingsystem.domain.User;
import com.kopivad.testingsystem.repository.data.UserRepository;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.time.LocalDateTime;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String id = (String) map.get("sub");
            User user = userRepository.findById(id).orElseGet(() -> {
                return User
                        .builder()
                        .id((String) map.get("sub"))
                        .email((String) map.get("email"))
                        .locale((String) map.get("locale"))
                        .picture((String) map.get("picture"))
                        .name((String) map.get("name"))
                        .roles(Collections.singleton(Role.USER))
                        .build();
            });
            user.setLastVisit(LocalDateTime.now());
            return userRepository.save(user);
        };
    }
}
