package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dev.ask.auth.application.service.user.FindUserByIdServiceImpl;
import dev.ask.auth.application.service.user.LoginUserServiceImpl;
import dev.ask.auth.application.service.user.RegisterUserServiceImpl;
import dev.ask.auth.application.service.user.ResetPasswordServiceImpl;
import dev.ask.auth.application.service.user.UpdateUserServiceImpl;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.audit_log.CreateAuditLogService;
import dev.ask.auth.domain.service.email.SendNewPasswordService;
import dev.ask.auth.domain.service.email.SendWelcomeEmailService;
import dev.ask.auth.domain.service.failed_login_attempts_ip.CheckAndUnblockIfExpiredService;
import dev.ask.auth.domain.service.failed_login_attempts_ip.HandleFailedLoginService;
import dev.ask.auth.domain.service.ip_block.IsIpBlockedService;
import dev.ask.auth.domain.service.login_event.FailedLoginEventService;
import dev.ask.auth.domain.service.login_event.SuccessLoginEventService;
import dev.ask.auth.domain.service.password_history.SavePasswordHistoryService;
import dev.ask.auth.domain.service.session.GetExistingSessionService;
import dev.ask.auth.domain.service.session.RevokeSessionService;
import dev.ask.auth.domain.service.token.ExistsActiveTokenForDeviceService;
import dev.ask.auth.domain.service.token.GenerateAccessTokenService;
import dev.ask.auth.domain.service.token.SaveTokenService;
import dev.ask.auth.domain.service.user.FindUserByIdService;
import dev.ask.auth.domain.service.user.LoginUserService;
import dev.ask.auth.domain.service.user.RegisterUserService;
import dev.ask.auth.domain.service.user.ResetPasswordService;
import dev.ask.auth.domain.service.user.UpdateUserService;

@Configuration
public class UserServiceConfig {

    @Bean
    FindUserByIdService findUserByIdService(UserRepository userRepository) {
        return new FindUserByIdServiceImpl(userRepository);
    }

    @Bean
    LoginUserService loginUserService(UserRepository userRepository, SaveTokenService saveTokenService,
            ExistsActiveTokenForDeviceService existsActiveTokenForDeviceService,
            RevokeSessionService revokeSessionService, BCryptPasswordEncoder passwordEncoder,
            CreateAuditLogService createAuditLogService, HandleFailedLoginService handleFailedLoginService,
            SuccessLoginEventService successLoginEventService, FailedLoginEventService failedLoginEventService,
            IsIpBlockedService isIpBlockedService, CheckAndUnblockIfExpiredService checkAndUnblockIpService,
            GetExistingSessionService getExistingSessionService,
            GenerateAccessTokenService generateAccessTokenService) {
        return new LoginUserServiceImpl(userRepository, saveTokenService, existsActiveTokenForDeviceService,
                revokeSessionService, passwordEncoder, createAuditLogService, handleFailedLoginService,
                successLoginEventService, failedLoginEventService, isIpBlockedService, checkAndUnblockIpService,
                getExistingSessionService, generateAccessTokenService);
    }

    @Bean
    RegisterUserService registerUserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
            SavePasswordHistoryService savePasswordHistoryService, CreateAuditLogService createAuditLogService,
            SendWelcomeEmailService sendWelcomeEmailService) {
        return new RegisterUserServiceImpl(userRepository, passwordEncoder, savePasswordHistoryService,
                createAuditLogService, sendWelcomeEmailService);
    }

    @Bean
    UpdateUserService updateUserService(UserRepository userRepository) {
        return new UpdateUserServiceImpl(userRepository);
    }

    @Bean
    ResetPasswordService resetPasswordService(UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder, SendNewPasswordService sendNewPasswordService,
            SavePasswordHistoryService savePasswordHistoryService) {
        return new ResetPasswordServiceImpl(userRepository, passwordEncoder, sendNewPasswordService,
                savePasswordHistoryService);
    }
}