package com.recrutement.modules.user.service;

import com.recrutement.exceptions.DataNotFoundException;
import com.recrutement.modules.user.User;
import com.recrutement.modules.user.dto.UserDto;

public interface IUserService {

    UserDto save(User user);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    UserDto saveDto(UserDto user);

    UserDto findByUsername(String username) throws DataNotFoundException;
}
