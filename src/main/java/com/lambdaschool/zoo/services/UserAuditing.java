package com.lambdaschool.zoo.services;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class UserAuditing implements AuditorAware<String>
{
    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uname;
        uname = "SYSTEM";
        return Optional.of(uname);
    }
}