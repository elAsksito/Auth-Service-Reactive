package dev.ask.auth.infrastructure.persistence.repository.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataUserRepository;
import dev.ask.auth.shared.enums.Status;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public Mono<UserDocument> createUser(String email, String password) {
        UserDocument user = UserDocument.builder()
                .email(email)
                .password(password)
                .isEmailVerified(false)
                .status(Status.ACTIVE)
                .failedLoginAttempts(0)
                .twoFaEnabled(false)
                .roles(List.of("USER"))
                .build();
        user.prePersist();

        return springDataUserRepository.save(user);
    }

    @Override
    public Mono<UserDocument> loginUser(String email, String password) {
        return springDataUserRepository
                .findByEmail(email);
    }

    @Override
    public Mono<UserDocument> findById(String userId) {
        return springDataUserRepository.findById(userId);
    }

    @Override
    public Mono<UserDocument> updateUser(String userId, UserDocument userDocument) {
        userDocument.setId(userId);
        userDocument.preUpdate();
        return springDataUserRepository.save(userDocument);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return springDataUserRepository.existsByEmail(email);
    }

    @Override
    public Mono<UserDocument> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email);
    }
}