package com.employee.employeeService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee_Table")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer employeeId;

  private String emploeeName;

  private String employeeAddress;

  private Double salary;

}
