package com.learn.security.login_register_system.service;

import com.learn.security.login_register_system.dto.UserDTO;

import java.util.UUID;


public interface UserService {


    void userSignUp(UserDTO userDTO, UUID uuid);
}
