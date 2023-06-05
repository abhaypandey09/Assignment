package com.Acnovate_Coding_Challenge.service;

import com.Acnovate_Coding_Challenge.entities.Employee;
import com.Acnovate_Coding_Challenge.payload.EmployeeDTO;
import com.Acnovate_Coding_Challenge.payload.SupervisorDTO;
import com.Acnovate_Coding_Challenge.repository.EmployeeRepository;
import com.Acnovate_Coding_Challenge.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final SupervisorRepository supervisorRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, SupervisorRepository supervisorRepository) {
        this.employeeRepository = employeeRepository;
        this.supervisorRepository = supervisorRepository;
    }

    public void saveEmployeeHierarchy(Map<String, String> hierarchy) {
        hierarchy.forEach((employeeName, supervisorName) -> {
            Employee employee = new Employee();
            employee.setName(employeeName);
            Employee supervisor = employeeRepository.findByName(supervisorName);
            employee.setSupervisor(supervisor);
            employeeRepository.save(employee);
        });
    }

    public EmployeeDTO getSupervisor(String employeeName) {
        Employee employee = employeeRepository.findByName(employeeName);
        if (employee != null) {
            Employee supervisor = employee.getSupervisor();
            if (supervisor != null) {
                return new EmployeeDTO(employee.getName(), supervisor.getName());
            }
        }
        return null;
    }

    public SupervisorDTO getSupervisorSupervisor(String employeeName) {
        Employee employee = employeeRepository.findByName(employeeName);
        if (employee != null) {
            Employee supervisor = employee.getSupervisor();
            if (supervisor != null) {
                Employee supervisorSupervisor = supervisor.getSupervisor();
                if (supervisorSupervisor != null) {
                    return new SupervisorDTO(supervisorSupervisor.getName());
                }
            }
        }
        return null;
    }
}



