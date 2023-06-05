package com.Acnovate_Coding_Challenge.payload;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String supervisorName;
    private String supervisorSupervisorName;

    public EmployeeDTO(String supervisorName, String supervisorSupervisorName) {
        this.supervisorName = supervisorName;
        this.supervisorSupervisorName = supervisorSupervisorName;
    }

    // Getters and setters
}
