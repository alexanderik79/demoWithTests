package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Manager;
import com.example.demowithtests.repository.ManagerRepository;
import com.example.demowithtests.service.ManagerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfig {
    private final ManagerService managerService;

    public SecurityConfig(ManagerService managerService) {
        this.managerService = managerService;
    }

    //TODO: 30-July-23 Create 2 users for demo
    @Bean
    public UserDetailsService userDetailsService() {

//        var userOne = User.withUsername("user").password("{noop}password").roles("USER").build();
//        var userTwo = User.withUsername("admin").password("{noop}password").roles("USER", "ADMIN").build();
//        return new InMemoryUserDetailsManager(userOne, userTwo);


        List<Manager> managers = managerService.getAll();
        List<UserDetails> managersDetailsList = managers.stream()
                .map(managerEntity -> User.withUsername(managerEntity.getName())
//                        .password(managerEntity.getPassword()) //для этого нужен BCryptPasswordEncoder. я пока не делал так как задача не стояла
                        .password("{noop}password")              //сделал лайт вариант как на уроке.
                        .roles(managerEntity.getRole())
                        .build())
                .collect(Collectors.toList());

        return new InMemoryUserDetailsManager(managersDetailsList);
    }

    // TODO: 30-July-23 Secure the endpoints with HTTP Basic authentication
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        return http
                //HTTP Basic authentication
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/users/jpa").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .build();
    }
}
