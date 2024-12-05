package com.exapmle.ems.repository;

import com.exapmle.ems.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query(value = "SELECT TOP 10 e.emp_id, e.emp_name, e.emp_salary, e.dep_id FROM employee e JOIN employee_dep d ON e.dep_id = d.dep_id " +
            "WHERE d.dep_name = :departmentName ORDER BY e.emp_salary DESC", nativeQuery = true)
    List<Employee> top10EarningEmployeesByDepartment(String departmentName);

    @Query(value = "SELECT e.emp_name, e.emp_salary, d.dep_name FROM employee e, employee_dep d" +
            " WHERE e.dep_id = d.dep_id AND e.emp_salary = (SELECT MAX(emp_salary) FROM employee WHERE dep_id = e.dep_id)", nativeQuery = true)
    List<Map<String, Object>> maxEarnerFromEachDepartments();
}
