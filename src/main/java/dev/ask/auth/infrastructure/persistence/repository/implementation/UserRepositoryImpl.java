package dev.ask.auth.infrastructure.persistence.repository.implementation;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public Mono<UserDocument> createUser(String email, String password) {
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public Mono<UserDocument> loginUser(String email, String password) {
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public Mono<UserDocument> findById(String userId) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Mono<UserDocument> updateUser(String userId, UserDocument userDocument) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
}