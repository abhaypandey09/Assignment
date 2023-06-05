package com.Acnovate_Coding_Challenge.controller;

import com.Acnovate_Coding_Challenge.payload.EmployeeDTO;
import com.Acnovate_Coding_Challenge.payload.SupervisorDTO;
import com.Acnovate_Coding_Challenge.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/api/employees
    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployeeHierarchy(@RequestBody Map<String, String> hierarchy) {
        employeeService.saveEmployeeHierarchy(hierarchy);
        return ResponseEntity.ok("Employee hierarchy saved successfully");
    }

    @GetMapping("/employees/{employeeName}/supervisor")
    public ResponseEntity<EmployeeDTO> getSupervisor(@PathVariable String employeeName) {
        EmployeeDTO dto = employeeService.getSupervisor(employeeName);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employees/{employeeName}/supervisor-supervisor")
    public ResponseEntity<SupervisorDTO> getSupervisorSupervisor(@PathVariable String employeeName) {
        SupervisorDTO dto = employeeService.getSupervisorSupervisor(employeeName);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


