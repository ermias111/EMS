package com.exapmle.ems.service;

import com.exapmle.ems.domain.Employee;
import com.exapmle.ems.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public List<Employee> top10EarningEmployeesByDepartment(String departmentName){
        List<Employee> res = new ArrayList<>();
        try {
            res = employeeRepository.top10EarningEmployeesByDepartment(departmentName);
        }catch (Exception e){
            logger.error("top10EarningEmployeesByDepartment failed for the reaason: " + e.getMessage(), e);
        }

        return res;
    }

    public List<Map<String, Object>> maxEarnerFromEachDepartments(){
        List<Map<String, Object>> res = new ArrayList<>();
        try {
            res = employeeRepository.maxEarnerFromEachDepartments();
        }catch (Exception e){
            logger.error("maxEarnerFromEachDepartments failed for the reaason: " + e.getMessage(), e);
        }

        return res;
    }
}
