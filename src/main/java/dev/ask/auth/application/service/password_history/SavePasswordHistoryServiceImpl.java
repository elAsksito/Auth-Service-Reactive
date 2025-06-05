package dev.ask.auth.application.service.password_history;

import dev.ask.auth.domain.model.PasswordHistory;
import dev.ask.auth.domain.repository.PasswordHistoryRepository;
import dev.ask.auth.domain.service.password_history.SavePasswordHistoryService;
import dev.ask.auth.infrastructure.persistence.mapper.PasswordHistoryMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SavePasswordHistoryServiceImpl implements SavePasswordHistoryService {

    private final PasswordHistoryRepository passwordHistoryRepository;

    @Override
    public Mono<PasswordHistory> savePasswordHistory(String userId, String passwordHash) {
        return passwordHistoryRepository.savePasswordHistory(userId, passwordHash).map(PasswordHistoryMapper::toDomain);
    }
}