package com.employee.employeeService.controller;


import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.dto.EmployeeReq;
import com.employee.employeeService.entity.Employee;
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
  private EmployeeDao employeeDao;


  @PostMapping(value = "/create")
  public ResponseEntity createEmployee(@RequestBody EmployeeReq employeeReq)
  {
    try{
      Employee employee=new Employee();
      BeanUtils.copyProperties(employeeReq,employee);
      employeeDao.save(employee);
      return ResponseEntity.ok().body(true);
    }catch (Exception e)
    {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(false);
    }

  }


  @GetMapping(value = "/getAll")
  public ResponseEntity getAll()
  {
    return ResponseEntity.ok(employeeDao.findAll());
  }

  @PutMapping(value = "/update")
  public ResponseEntity updateEmployee(@RequestBody EmployeeReq employeeReq)
  {
    try{
      Employee employee=new Employee();
      BeanUtils.copyProperties(employeeReq,employee);
      employee.setEmployeeId(employeeReq.getEmployeeId());
      employeeDao.save(employee);
      return ResponseEntity.ok().body(true);
    }catch (Exception e)
    {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(false);
    }
  }

  @GetMapping(value = "/getById/{employeeId}")
  public ResponseEntity createEmployee(@PathVariable("employeeId") Integer employeeId)
  {
    return ResponseEntity.ok().body(employeeDao.findById(employeeId));
  }

}
