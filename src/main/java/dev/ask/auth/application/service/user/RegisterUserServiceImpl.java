package dev.ask.auth.application.service.user;

import java.time.LocalDateTime;

import dev.ask.auth.domain.model.User;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.user.RegisterUserService;
import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import dev.ask.auth.infrastructure.persistence.mapper.UserMapper;
import dev.ask.auth.shared.enums.Status;
import dev.ask.auth.shared.payload.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegisterUserServiceImpl implements RegisterUserService {

    private final UserRepository userRepository;

    @Override
    public Mono<User> createUserWithEmailAndPassword(LoginRequest request, String ipAddress, String userAgent) {

        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .isEmailVerified(false)
                .status(Status.ACTIVE)
                .failedLoginAttempts(0)
                .lockUntil(null)
                .twoFaEnabled(false)
                .twoFaSecret(null)
                .lastLogin(null)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .version(1L)
                .mustChangePassword(false)
                .roles(new String[] { "USER" })
                .build();

        UserDocument userDocument = UserMapper.toDocument(user);

        return userRepository.save(userDocument)
                .map(UserMapper::toDomain)
                .switchIfEmpty(Mono.error(new RuntimeException("Failed to create user")));

    }

}
