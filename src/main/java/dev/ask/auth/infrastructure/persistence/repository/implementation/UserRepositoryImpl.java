package dev.ask.auth.infrastructure.persistence.repository.implementation;

import org.springframework.stereotype.Repository;

import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.infrastructure.persistence.document.UserDocument;
import dev.ask.auth.infrastructure.persistence.repository.interfaces.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public Mono<UserDocument> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return springDataUserRepository.existsByEmail(email);
    }

    @Override
    public Flux<UserDocument> findByRole(String role) {
        return springDataUserRepository.findByRole(role);
    }

    @Override
    public Mono<UserDocument> save(UserDocument user) {
        user.prePersist();
        return springDataUserRepository.save(user);
    }

    @Override
    public Mono<UserDocument> findById(String id) {
        return springDataUserRepository.findById(id);
    }

    @Override
    public Mono<UserDocument> update(String userId, UserDocument user) {
        return springDataUserRepository.findById(userId)
                .flatMap(existingUser -> {

                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setEmailVerified(user.isEmailVerified());
                    existingUser.setStatus(user.getStatus());
                    existingUser.setFailedLoginAttempts(user.getFailedLoginAttempts());
                    existingUser.setLockUntil(user.getLockUntil());
                    existingUser.setTwoFaEnabled(user.isTwoFaEnabled());
                    existingUser.setTwoFaSecret(user.getTwoFaSecret());
                    existingUser.setLastLogin(user.getLastLogin());
                    existingUser.setPasswordLastChanged(user.getPasswordLastChanged());
                    existingUser.setMustChangePassword(user.isMustChangePassword());
                    existingUser.setRoles(user.getRoles());
                    existingUser.preUpdate();
                    return springDataUserRepository.save(existingUser);
                });
    }
}