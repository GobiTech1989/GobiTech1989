package com.gobi.rohit.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		Optional<String> returnValue = Optional.empty();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (Objects.nonNull(authentication) && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getName())) {
			returnValue = Optional.of(authentication.getName());
		} else {
			returnValue = Optional.of("Gobinath");
		}
		return returnValue;
	}

}
