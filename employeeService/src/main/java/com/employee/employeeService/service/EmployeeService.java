package com.employee.employeeService.service;

import com.employee.employeeService.dto.EmployeeReq;
import com.employee.employeeService.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    Boolean createEmployee(EmployeeReq employeeReq);

    List getAll();

    Boolean updateEmployee(EmployeeReq employeeReq);

    Employee getById(Integer employeeId);
}
