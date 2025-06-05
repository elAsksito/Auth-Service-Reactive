package dev.ask.auth.application.service.password_history;

import dev.ask.auth.domain.repository.PasswordHistoryRepository;
import dev.ask.auth.domain.service.password_history.IsPasswordUsedService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class IsPasswordUsedServiceImpl implements IsPasswordUsedService {

    private final PasswordHistoryRepository passwordHistoryRepository;

    @Override
    public Mono<Boolean> isPasswordUsed(String userId, String passwordHash) {
        return passwordHistoryRepository.isPasswordUsed(userId, passwordHash);
    }
}