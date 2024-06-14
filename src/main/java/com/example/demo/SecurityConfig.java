package com.example.demo;

import jakarta.security.auth.message.config.AuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

//    @Bean
//    public AuthenticationManager authenticationManager(CustomUserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
//
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(passwordEncoder);
//        authenticationProvider.setUserDetailsService(userDetailsService);
//
//        return new ProviderManager(authenticationProvider);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((requests) -> {requests.requestMatchers("/home").hasAuthority("USER")
                        .requestMatchers("/register", "/login", "/css/**", "/h2-console/**").permitAll()
                        .anyRequest().authenticated();})
                .formLogin((form) -> form.loginPage("/login").defaultSuccessUrl("/home").permitAll())
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }


}
