package com.employee.employeeService.service.impl;

import com.employee.employeeService.dao.EmployeeDao;
import com.employee.employeeService.dto.EmployeeReq;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public Boolean createEmployee(EmployeeReq employeeReq) {
        try{
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeReq,employee);
            employeeDao.save(employee);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAll() {
        return  employeeDao.findAll();
    }

    @Override
    public Boolean updateEmployee(EmployeeReq employeeReq) {
        try{
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeReq,employee);
            employee.setEmployeeId(employeeReq.getEmployeeId());
            employeeDao.save(employee);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Employee getById(Integer employeeId) {
        return employeeDao.findById(employeeId).get();
    }
}
