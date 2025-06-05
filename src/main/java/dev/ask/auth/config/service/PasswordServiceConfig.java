package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.password_history.SavePasswordHistoryServiceImpl;
import dev.ask.auth.domain.repository.PasswordHistoryRepository;
import dev.ask.auth.domain.service.password_history.IsPasswordUsedService;
import dev.ask.auth.domain.service.password_history.SavePasswordHistoryService;

@Configuration
public class PasswordServiceConfig {
    @Bean
    SavePasswordHistoryService savePasswordHistoryService(PasswordHistoryRepository passwordHistoryRepository) {
        return new SavePasswordHistoryServiceImpl(passwordHistoryRepository);
    }

    @Bean
    IsPasswordUsedService isPasswordUsedService(PasswordHistoryRepository passwordHistoryRepository) {
        return passwordHistoryRepository::isPasswordUsed;
    }
}