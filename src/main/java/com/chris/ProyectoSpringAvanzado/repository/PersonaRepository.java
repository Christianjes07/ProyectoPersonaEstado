package com.chris.ProyectoSpringAvanzado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chris.ProyectoSpringAvanzado.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("SELECT p FROM Persona p WHERE p.estado.idEstado = 4")
    List<Persona> mostrarPersonasConId();

    @Query("SELECT p FROM Persona p JOIN FETCH p.estado")
    List<Persona> mostrarPersonasEstado();

    @Query("SELECT COUNT(p) FROM Persona p")
    Long contarPersonas();

}
