package com.exapmle.ems.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_dep")
public class Department {
    @Id
    @Column(name = "dep_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dep_name")
    private String departmentName;

    @Column(name = "dep_desc")
    private String description;
}
