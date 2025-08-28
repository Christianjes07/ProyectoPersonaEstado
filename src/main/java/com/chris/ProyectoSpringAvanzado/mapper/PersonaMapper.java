package com.chris.ProyectoSpringAvanzado.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.ProyectoSpringAvanzado.dto.PersonaDTO;
import com.chris.ProyectoSpringAvanzado.model.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    @Mapping(source = "estado.nombre", target = "nombreEstado")
    PersonaDTO toDto(Persona persona); // persona a personaDTO

    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "fechaNacimiento", ignore = true)

    Persona toEntity(PersonaDTO personaDTO); // DE PERSONADTO A PERSONA

}
