package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.user.LoginUserServiceImpl;
import dev.ask.auth.application.service.user.RegisterUserServiceImpl;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.user.LoginUserService;
import dev.ask.auth.domain.service.user.RegisterUserService;

@Configuration
public class UserServiceConfig {
    @Bean
    RegisterUserService registerUserService(UserRepository userRepository) {
        return new RegisterUserServiceImpl(userRepository);
    }

    @Bean
    LoginUserService loginUserService(UserRepository userRepository) {
        return new LoginUserServiceImpl(userRepository);
    }
}