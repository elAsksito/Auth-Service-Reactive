package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.failed_login_attempts_ip.CheckAndUnblockIfExpiredServiceImpl;
import dev.ask.auth.application.service.failed_login_attempts_ip.HandleFailedLoginServiceImpl;
import dev.ask.auth.domain.repository.FailedLoginAttemptsIpRepository;
import dev.ask.auth.domain.service.failed_login_attempts_ip.CheckAndUnblockIfExpiredService;
import dev.ask.auth.domain.service.failed_login_attempts_ip.HandleFailedLoginService;

@Configuration
public class FailedLoginAttemptsIpServiceConfig {
    @Bean
    HandleFailedLoginService handleFailedLoginService(FailedLoginAttemptsIpRepository failedLoginAttemptsIpRepository) {
        return new HandleFailedLoginServiceImpl(failedLoginAttemptsIpRepository);
    }

    @Bean
    CheckAndUnblockIfExpiredService checkAndUnblockIfExpiredService(
            FailedLoginAttemptsIpRepository failedLoginAttemptsIpRepository) {
        return new CheckAndUnblockIfExpiredServiceImpl(failedLoginAttemptsIpRepository);
    }
}