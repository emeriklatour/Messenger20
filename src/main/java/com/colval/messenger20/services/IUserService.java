package com.colval.messenger20.services;

import com.colval.messenger20.exception.UserAlreadyExistsAuthenticationException;
import com.colval.messenger20.model.DTO.UserDto;
import com.colval.messenger20.model.entities.Users;

import java.util.Optional;

public interface IUserService {
    Users create(Users user);
    Users findByUsername(String username);
    Optional<Users> readOne(Short id);
    void save(UserDto userDto);
    void register(UserDto userDto) throws UserAlreadyExistsAuthenticationException;
}
