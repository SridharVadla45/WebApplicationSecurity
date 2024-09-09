package com.learn.security.login_register_system.controller;


import com.learn.security.login_register_system.dto.EmployeeDTO;
import com.learn.security.login_register_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
//    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerEmployee(@RequestBody EmployeeDTO employeeDTO){
        // call a service to store employee details & returns if exception occurs
        employeeService.registerEmployeeToDb(employeeDTO);
        return ResponseEntity.status(201).body("Registration successfully");
    }


    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Welcome to Employee test Method without authentication", HttpStatus.OK);
    }


    @GetMapping("/testAuth")
    public ResponseEntity<String> testAuth(){
        return new ResponseEntity<>("Welcome to Employee test Method with Authentication  ", HttpStatus.OK);
    }

//
//    @PostMapping("/user-signUp")
//    public ResponseEntity<String> registerEmployee(@RequestBody UserDTO userDTO){
//        // call a service to store employee details & returns if exception occurs
//        UUID uuid = UUID.randomUUID();
//        log.info("{} user invoked signUp", uuid);
//        userService.userSignUp(userDTO,uuid);
//        log.info("{} user  signedUp successfully ", uuid);
//        return ResponseEntity.status(201).body("user signUp  successfully");
//    }


}
