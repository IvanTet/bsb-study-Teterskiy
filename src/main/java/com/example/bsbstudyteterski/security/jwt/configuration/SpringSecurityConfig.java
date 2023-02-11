package com.example.bsbstudyteterski.security.jwt.configuration;

import com.example.bsbstudyteterski.security.jwt.JwtCsrfFilter;
import com.example.bsbstudyteterski.security.jwt.JwtTokenRepository;
import com.example.bsbstudyteterski.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {


    private UserService service;
    private JwtTokenRepository jwtTokenRepository;

    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    public SpringSecurityConfig(UserService service, JwtTokenRepository jwtTokenRepository, HandlerExceptionResolver resolver) {
        this.service = service;
        this.jwtTokenRepository = jwtTokenRepository;
        this.resolver = resolver;
    }

    @Bean
    public PasswordEncoder devPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                .csrf().ignoringRequestMatchers("/**")
                .and()
                .authorizeHttpRequests()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/user/login"))
                .authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(((request, response, e) -> resolver.resolveException(request, response, null, e)));
        return http.build();
    }

}
