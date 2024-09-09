package com.learn.security.login_register_system.service.Impl;

import com.learn.security.login_register_system.constants.EmployeeConstants;
import com.learn.security.login_register_system.dto.EmployeeDTO;
import com.learn.security.login_register_system.exception.ResourceAlreadyExistsException;
import com.learn.security.login_register_system.mapper.EmployeeMapper;
import com.learn.security.login_register_system.model.Employee;
import com.learn.security.login_register_system.repository.EmployeeRepository;
import com.learn.security.login_register_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void registerEmployeeToDb(EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeEmail(employeeDTO.getEmail());
        if (employeeOptional.isPresent()) throw new ResourceAlreadyExistsException(EmployeeConstants.EMPLOYEE, "email");
        Employee employee = EmployeeMapper.employeeDtoToEmployee(employeeDTO, new Employee());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee= employeeRepository.findByEmployeeEmail(username).orElseThrow(()->new UsernameNotFoundException("user not found for user :"+username));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("user"));
        return new User(employee.getEmployeeEmail(),employee.getPassword(),authorities);
    }
}
