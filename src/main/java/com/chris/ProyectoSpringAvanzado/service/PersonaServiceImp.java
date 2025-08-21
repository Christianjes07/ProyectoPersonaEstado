package com.chris.ProyectoSpringAvanzado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.chris.ProyectoSpringAvanzado.dto.PersonaDTO;
import com.chris.ProyectoSpringAvanzado.exception.RecursoNoEncontradoException;
import com.chris.ProyectoSpringAvanzado.model.Persona;
import com.chris.ProyectoSpringAvanzado.repository.PersonaRepository;

@Service
public class PersonaServiceImp implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImp(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;

    }

    @Override
    public Persona savePersona(Persona persona) {

        return personaRepository.save(persona);

    }

    @Override
    public Persona getIdPersona(Long idPersona) {

        Persona persona = personaRepository.findById(idPersona)
                .orElseThrow((() -> new RecursoNoEncontradoException("Persona no encontrada con el id: " + idPersona)));

        return persona;

    }

    @Override
    public List<Persona> getAllPersonas() {

        return personaRepository.findAll();
    }

    @Override
    public Persona updatePersona(Long idPersona, Persona persona) {
        Persona personaActualizada = personaRepository.findById(idPersona)
                .orElseThrow(() -> new RecursoNoEncontradoException("Persona no encontrada"));

        personaActualizada.setNombre(persona.getNombre());
        personaActualizada.setEmail(persona.getEmail());
        personaActualizada.setFechaNacimiento(persona.getFechaNacimiento());
        personaActualizada.setEstado(persona.getEstado());

        return personaRepository.save(personaActualizada);

    }

    @Override
    public void deletePersona(Long idPersona) {
        Persona personaExiste = personaRepository.findById(idPersona)
                .orElseThrow(() -> new RecursoNoEncontradoException("Persona no encontarada con el id:" + idPersona));

        personaRepository.delete(personaExiste);

    }

    @Override
    public List<PersonaDTO> listaPersonas() {

        List<Persona> listarPersonas = personaRepository.findAll();

        return listarPersonas.stream()
                .map(persona -> new PersonaDTO(
                        persona.getIdPersona(),
                        persona.getNombre(),
                        persona.getEstado().getNombre()))
                .collect(Collectors.toList());

    }

    @Override
    public PersonaDTO listarPersonaDTOs(Persona persona) {

        PersonaDTO dto = new PersonaDTO();

        dto.setNombre(persona.getNombre());
        dto.setIdPersona(persona.getIdPersona());
        dto.setNombreEstado(persona.getEstado().getNombre());

        return dto;

    }

}
