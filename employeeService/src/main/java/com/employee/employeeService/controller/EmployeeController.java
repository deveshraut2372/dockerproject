package com.employee.employeeService.controller;


import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.dto.EmployeeReq;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.service.EmployeeService;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/Employee/")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;


  @PostMapping(value = "/create")
  public ResponseEntity createEmployee(@RequestBody EmployeeReq employeeReq)
  {
    Boolean flag;
    flag=employeeService.createEmployee(employeeReq);

    if(flag)
    {
      return new ResponseEntity( flag,HttpStatus.OK);
    }else {
      return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/getAll")
  public ResponseEntity getAll()
  {
    return new ResponseEntity(employeeService.getAll(),HttpStatus.OK);
  }

  @PutMapping(value = "/update")
  public ResponseEntity updateEmployee(@RequestBody EmployeeReq employeeReq)
  {
   Boolean flag=employeeService.updateEmployee(employeeReq);
    if(flag)
    {
      return new ResponseEntity( flag,HttpStatus.OK);
    }else {
      return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/getById/{employeeId}")
  public ResponseEntity getById(@PathVariable("employeeId") Integer employeeId)
  {
    return new ResponseEntity(employeeService.getById(employeeId),HttpStatus.OK);
  }

}
