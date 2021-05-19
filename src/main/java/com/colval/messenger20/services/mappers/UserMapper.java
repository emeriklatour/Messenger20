package com.colval.messenger20.services.mappers;

import com.colval.messenger20.model.DTO.UserDto;
import com.colval.messenger20.model.entities.Users;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements EntityToDto<Users, UserDto> {
    @Override
    public UserDto entityToDto(Users user) {
        return new UserDto(
            user.getUserId(),
            user.getFirstName(),
            user.getLastName(),
            user.getPassword(),
            user.getUsername()
        );
    }
}
