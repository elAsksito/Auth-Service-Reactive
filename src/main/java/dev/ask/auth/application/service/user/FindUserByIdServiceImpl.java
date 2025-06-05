package dev.ask.auth.application.service.user;

import dev.ask.auth.domain.model.User;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.user.FindUserByIdService;
import dev.ask.auth.domain.vo.UserId;
import dev.ask.auth.infrastructure.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindUserByIdServiceImpl implements FindUserByIdService {

    private final UserRepository userRepository;

    @Override
    public Mono<User> findById(String userId) {
        UserId idUser = new UserId(userId);
        return userRepository.findById(idUser.value()).map(UserMapper::toDomain);
    }
}