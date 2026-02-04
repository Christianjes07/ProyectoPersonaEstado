package com.chris.ProyectoSpringAvanzado.service;

import java.util.List;

import com.chris.ProyectoSpringAvanzado.dto.PersonaDTO;
import com.chris.ProyectoSpringAvanzado.model.Persona;

public interface PersonaService {

    Persona savePersona(Persona persona);

    Persona getIdPersona(Long idPersona);

    List<Persona> getAllPersonas();

    Persona updatePersona(Long idPersona, Persona persona);

    //con stream
    List <PersonaDTO> listaPersonas();

    void deletePersona(Long idPersona);


    //manualmente
   PersonaDTO listarPersonaDTOs(Long idPersona);

   List <PersonaDTO> listarPersonasMapper();


   //CONSULTAS PERSONALIZADAS

   List<Persona> listarPersonasPorEstado();

   List <Persona> listarPersonaConEstado();

   Long contarPersonas();


   //pruebas unitarias
   List<Persona> listsUnitaria();
}
