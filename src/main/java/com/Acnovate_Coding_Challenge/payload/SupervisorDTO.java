package com.Acnovate_Coding_Challenge.payload;

import lombok.Data;
@Data
public class SupervisorDTO {
    private String supervisorName;

    public SupervisorDTO(String supervisorName) {
        this.supervisorName = supervisorName;
    }


}



