package com.careassistant.users.repository;

import com.careassistant.users.model.ProfesionalSalud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalSaludRepository extends JpaRepository<ProfesionalSalud, Long> {

	@Query("SELECT p FROM ProfesionalSalud p WHERE (:especialidad IS NULL OR LOWER(p.especialidad) = LOWER(:especialidad)) AND (:ciudad IS NULL OR LOWER(p.ciudad) = LOWER(:ciudad))")
	List<ProfesionalSalud> buscarPorFiltros(@Param("especialidad") String especialidad, @Param("ciudad") String ciudad);

}
