package com.exapmle.ems.controller;

import com.exapmle.ems.domain.Employee;
import com.exapmle.ems.repository.EmployeeRepository;
import com.exapmle.ems.service.EmployeeService;
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
    private EmployeeService employeeService;

    @GetMapping(path = "/top10Earning")
    public ResponseEntity<List<Employee>> top10EarningEmployeesPerDepartment(@Param("department") String department){
        return new ResponseEntity<>(employeeService.top10EarningEmployeesByDepartment(department), HttpStatus.OK);
    }

    @GetMapping(path = "/maxEarnersInAllDepartments")
    public ResponseEntity<List<Map<String, Object>>> maxEarnersInEachDepartment(){
        return new ResponseEntity<>(employeeService.maxEarnerFromEachDepartments(), HttpStatus.OK);
    }
}
