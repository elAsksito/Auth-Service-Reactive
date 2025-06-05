package dev.ask.auth.config.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ask.auth.application.service.ip_block.BlockIpServiceImpl;
import dev.ask.auth.application.service.ip_block.UnblockIpServiceImpl;
import dev.ask.auth.domain.repository.IpBlockRepository;
import dev.ask.auth.domain.service.ip_block.BlockIpService;
import dev.ask.auth.domain.service.ip_block.IsIpBlockedService;
import dev.ask.auth.domain.service.ip_block.UnblockIpService;

@Configuration
public class IpBlockServiceConfig {

    @Bean
    UnblockIpService unblockIpService(IpBlockRepository ipBlockRepository) {
        return new UnblockIpServiceImpl(ipBlockRepository);
    }

    @Bean
    IsIpBlockedService idIpBlockedService(IpBlockRepository ipBlockRepository) {
        return ipBlockRepository::isIpBlocked;
    }

    @Bean
    BlockIpService blockIpService(IpBlockRepository ipBlockRepository) {
        return new BlockIpServiceImpl(ipBlockRepository);
    }
}