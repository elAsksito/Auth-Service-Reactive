package dev.ask.auth.application.service.user;

import dev.ask.auth.application.payload.request.LoginRequest;
import dev.ask.auth.domain.model.User;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.user.LoginUserService;
import dev.ask.auth.domain.vo.Email;
import dev.ask.auth.domain.vo.Password;
import dev.ask.auth.infrastructure.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class LoginUserServiceImpl implements LoginUserService {
    private final UserRepository userRepository;

    @Override
    public Mono<User> loginUserWithEmailAndPassword(LoginRequest request, String ipAddress, String userAgent) {
        Email email = new Email(request.getEmail());
        Password password = new Password(request.getPassword());
        return userRepository.loginUser(email.value(), password.value()).map(UserMapper::toDomain);
    }
}