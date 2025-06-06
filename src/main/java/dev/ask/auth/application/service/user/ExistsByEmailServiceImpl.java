package dev.ask.auth.application.service.user;

import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.user.ExistsByEmailService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExistsByEmailServiceImpl implements ExistsByEmailService {

    private final UserRepository userRepository;

    @Override
    public reactor.core.publisher.Mono<Boolean> existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    
}
