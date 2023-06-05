package com.Acnovate_Coding_Challenge.repository;

import com.Acnovate_Coding_Challenge.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
}


