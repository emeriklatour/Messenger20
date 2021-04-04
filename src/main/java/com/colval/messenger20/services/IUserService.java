package com.colval.messenger20.services;

import com.colval.messenger20.model.entities.Users;

public interface IUserService {
    Users create(Users user);
    Users readOne(String username);
}
