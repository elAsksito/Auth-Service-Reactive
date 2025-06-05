package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.login_event.FailedLoginEventServiceImpl;
import dev.ask.auth.application.service.login_event.SuccessLoginEventServiceImpl;
import dev.ask.auth.domain.repository.LoginEventRepository;
import dev.ask.auth.domain.service.login_event.FailedLoginEventService;
import dev.ask.auth.domain.service.login_event.SuccessLoginEventService;

@Configuration
public class FailedLoginEventServiceConfig {

    @Bean
    SuccessLoginEventService successLoginEventService(LoginEventRepository loginEventRepository) {
        return new SuccessLoginEventServiceImpl(loginEventRepository);
    }

    @Bean
    FailedLoginEventService failedLoginEventService(LoginEventRepository loginEventRepository) {
        return new FailedLoginEventServiceImpl(loginEventRepository);
    }
}