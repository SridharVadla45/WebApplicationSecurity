//package com.learn.security.login_register_system.service.Impl;
//
//import com.learn.security.login_register_system.dto.UserDTO;
//import com.learn.security.login_register_system.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//
//@Slf4j
////public class UserServiceImpl implements UserService, UserDetailsService {
//
////    private final UserDetailsManager userDetailsManager;
////    private final PasswordEncoder passwordEncoder;
////
////    @Autowired
////    public UserServiceImpl(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
////        this.userDetailsManager = userDetailsManager;
////        this.passwordEncoder = passwordEncoder;
////    }
////
////    @Override
////    public void userSignUp(UserDTO userDTO, UUID uuid) {
////        try {
////            List<GrantedAuthority> userAuthorities = new ArrayList<>();
////            userAuthorities.add(new SimpleGrantedAuthority("user"));
////            userAuthorities.add(new SimpleGrantedAuthority("admin"));
////            User user = new User(userDTO.getUserName(), passwordEncoder.encode(userDTO.getUserPassword()), userAuthorities);
////            userDetailsManager.createUser(user);
////            log.info("{} :  user record created in database",uuid);
////        }catch (Exception e){
////            log.info("{} An exception occurred , Message : {}",uuid,e.getMessage());
////        }
////    }
////
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        return null;
////    }
//}
