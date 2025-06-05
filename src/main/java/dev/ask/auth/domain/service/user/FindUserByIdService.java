package dev.ask.auth.domain.service.user;

import dev.ask.auth.domain.model.User;
import reactor.core.publisher.Mono;

public interface FindUserByIdService {
    Mono<User> findById(String userId);
}