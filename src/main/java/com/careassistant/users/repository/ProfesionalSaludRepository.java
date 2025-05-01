package com.careassistant.users.repository;

import com.careassistant.users.model.ProfesionalSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalSaludRepository extends JpaRepository<ProfesionalSalud, Long> {
}
