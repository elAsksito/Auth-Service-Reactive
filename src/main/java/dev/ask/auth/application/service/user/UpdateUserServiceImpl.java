package dev.ask.auth.application.service.user;

import dev.ask.auth.domain.model.User;
import dev.ask.auth.domain.repository.UserRepository;
import dev.ask.auth.domain.service.user.UpdateUserService;
import dev.ask.auth.domain.vo.UserId;
import dev.ask.auth.infrastructure.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateUserServiceImpl implements UpdateUserService {

    private final UserRepository userRepository;

    @Override
    public Mono<User> updateUser(String userId, User user) {
        UserId idUser = new UserId(userId);
        return userRepository
                .updateUser(idUser.value(), UserMapper.toDocument(user))
                .map(UserMapper::toDomain);
    }
}