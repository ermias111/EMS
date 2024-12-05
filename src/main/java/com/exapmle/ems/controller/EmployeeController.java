package com.exapmle.ems.controller;

import com.exapmle.ems.domain.Employee;
import com.exapmle.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path = "/top10")
    public ResponseEntity<List<Employee>> top10Employees(@Param("department") String department){
        return new ResponseEntity<>(employeeRepository.top10EarningEmployeesByDepartment(department), HttpStatus.OK);
    }

    @GetMapping(path = "/maxEarner")
    public ResponseEntity<List<Map<String, Object>>> maxEarner(){
        return new ResponseEntity<>(employeeRepository.maxEarnerFromEachDepartments(), HttpStatus.OK);
    }
}
