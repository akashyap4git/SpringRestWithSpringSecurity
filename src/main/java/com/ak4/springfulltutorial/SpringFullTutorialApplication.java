package com.ak4.springfulltutorial;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.ak4.config",
        "com.ak4.rest",
        "com.ak4.mapper",
        "com.ak4.service",
        "com.ak4.security"
})
@EnableJpaRepositories(basePackages = "com.ak4.repository")
public class SpringFullTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFullTutorialApplication.class, args);
    }

}

