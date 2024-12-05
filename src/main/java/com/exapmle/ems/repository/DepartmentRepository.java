package com.exapmle.ems.repository;

import com.exapmle.ems.domain.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
