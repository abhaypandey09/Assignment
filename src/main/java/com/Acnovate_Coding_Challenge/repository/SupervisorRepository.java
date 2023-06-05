package com.Acnovate_Coding_Challenge.repository;

import com.Acnovate_Coding_Challenge.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
    Supervisor findByName(String name);
}


