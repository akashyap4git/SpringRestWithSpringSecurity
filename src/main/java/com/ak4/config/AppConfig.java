package com.ak4.config;

import com.ak4.security.CustomUserDetails;
import com.ak4.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collection;

@Configuration
@PropertySource(value = "classpath:myapp.properties", ignoreResourceNotFound = true)
public class AppConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        Collection<UserDetails> users = Arrays.asList(
                new CustomUserDetails("aditi", passwordEncoder.encode("aditi"), true, "USER"),
                new CustomUserDetails("aayushi", passwordEncoder.encode("aayushi"), true, "USER", "ADMIN")
        );
        return new CustomUserDetailsService(users);
    }
}
