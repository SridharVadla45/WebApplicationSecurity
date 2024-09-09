package com.learn.security.login_register_system.dto;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UserDTO {

    private String userName;

    private String userPassword;

}
