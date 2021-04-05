package com.colval.messenger20.services.implementation;

import com.colval.messenger20.exception.UserAlreadyExistsAuthenticationException;
import com.colval.messenger20.model.DTO.UserDto;
import com.colval.messenger20.model.entities.Authorities;
import com.colval.messenger20.model.entities.Users;
import com.colval.messenger20.repositories.interfaces.IUserRepository;
import com.colval.messenger20.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    private final AuthorityService authorityService;

    @Autowired
    public UserService(IUserRepository userRepository, AuthorityService authorityService) {
        this.userRepository = userRepository;
        this.authorityService = authorityService;
    }

    @Override
    public Users create(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users readOne(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(UserDto userDto) throws UserAlreadyExistsAuthenticationException {
        if (readOne(userDto.getUsername()) != null) {
            throw new UserAlreadyExistsAuthenticationException("User already exists with this username");
        }
        Users user = new Users();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder().encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEnabled(true);
        this.create(user);

        Authorities authority = new Authorities();
        authority.setUsername(userDto.getUsername());
        authority.setAuthority("USER");
        authorityService.create(authority);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
