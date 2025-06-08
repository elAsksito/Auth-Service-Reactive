package dev.ask.auth.application.service.reset_code;

import java.time.Duration;

import dev.ask.auth.domain.service.reset_code.SaveResetCodeService;
import reactor.core.publisher.Mono;

public class SaveResetCodeServiceImpl implements SaveResetCodeService {

    

    @Override
    public Mono<Void> saveResetCode(String email, String code, Duration duration) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveResetCode'");
    }
    
}