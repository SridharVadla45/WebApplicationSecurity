package com.learn.security.login_register_system.mapper;

import com.learn.security.login_register_system.dto.EmployeeDTO;
import com.learn.security.login_register_system.model.Employee;

public class EmployeeMapper {

    public static Employee employeeDtoToEmployee(EmployeeDTO employeeDTO,Employee employee){
        employee.setEmployeeEmail(employeeDTO.getEmail());
        employee.setEmployeeName(employeeDTO.getName());
        employee.setEmployeeMobileNumber(employeeDTO.getMobileNumber());
        employee.setPassword(employeeDTO.getPassword());

        return employee;
    }
}
