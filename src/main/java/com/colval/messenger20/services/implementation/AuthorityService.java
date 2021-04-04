package com.colval.messenger20.services.implementation;

import com.colval.messenger20.model.entities.Authorities;
import com.colval.messenger20.repositories.interfaces.IAuthorityRepository;
import com.colval.messenger20.services.IAuthorityService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService implements IAuthorityService {
    private final IAuthorityRepository authorityRepository;

    public AuthorityService(IAuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authorities create(Authorities authority) {
        return this.authorityRepository.save(authority);
    }
}
