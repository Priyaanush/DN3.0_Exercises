package com.example.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Replace with actual user retrieval logic
        return Optional.of("system"); // Hardcoded user for demo
    }
}
