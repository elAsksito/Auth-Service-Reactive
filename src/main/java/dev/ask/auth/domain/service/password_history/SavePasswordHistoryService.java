package dev.ask.auth.domain.service.password_history;

import dev.ask.auth.domain.model.PasswordHistory;
import reactor.core.publisher.Mono;

public interface SavePasswordHistoryService {
    Mono<PasswordHistory> savePasswordHistory(String userId, String passwordHash);
}