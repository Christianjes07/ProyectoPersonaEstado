package com.chris.ProyectoSpringAvanzado.service;

import java.util.List;

import com.chris.ProyectoSpringAvanzado.dto.PersonaDTO;
import com.chris.ProyectoSpringAvanzado.model.Persona;

public interface PersonaService {

    Persona savePersona(Persona persona);

    Persona getIdPersona(Long idPersona);

    List<Persona> getAllPersonas();

    Persona updatePersona(Long idPersona, Persona persona);

    List <PersonaDTO> listaPersonas();

    void deletePersona(Long idPersona);

    PersonaDTO listarPersonaDTOs(Persona persona);

}
