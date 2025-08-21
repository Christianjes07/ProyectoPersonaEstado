package com.chris.ProyectoSpringAvanzado.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chris.ProyectoSpringAvanzado.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {


}
