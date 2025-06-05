package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.user.FindUserByIdServiceImpl;
import dev.ask.auth.application.service.user.LoginUserServiceImpl;
import dev.ask.auth.application.service.user.RegisterUserServiceImpl;
import dev.ask.auth.application.service.user.UpdateUserServiceImpl;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.user.FindUserByIdService;
import dev.ask.auth.domain.service.user.LoginUserService;
import dev.ask.auth.domain.service.user.RegisterUserService;
import dev.ask.auth.domain.service.user.UpdateUserService;

@Configuration
public class UserServiceConfig {

    @Bean
    FindUserByIdService findUserByIdService(UserRepository userRepository) {
        return new FindUserByIdServiceImpl(userRepository);
    }

    @Bean
    LoginUserService loginUserService(UserRepository userRepository) {
        return new LoginUserServiceImpl(userRepository);
    }

    @Bean
    RegisterUserService registerUserService(UserRepository userRepository) {
        return new RegisterUserServiceImpl(userRepository);
    }

    @Bean
    UpdateUserService updateUserService(UserRepository userRepository) {
        return new UpdateUserServiceImpl(userRepository);
    }
}