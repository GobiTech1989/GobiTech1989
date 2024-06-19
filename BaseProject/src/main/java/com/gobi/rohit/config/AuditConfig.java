package com.gobi.rohit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gobi.rohit.service.impl.AuditorAwareImpl;

@EnableJpaAuditing
@Configuration
public class AuditConfig {

	@Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
