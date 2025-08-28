package com.chris.ProyectoSpringAvanzado.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.ProyectoSpringAvanzado.dto.EstadoDTO;
import com.chris.ProyectoSpringAvanzado.model.Estado;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

    EstadoDTO toDTO(Estado estado); //convertir entidad a dto para enviar datos al cliente que nos pide y no mostrar datos que por seguridad no queremos mostrar

    @Mapping(target = "idEstado", ignore = true) //ignoramos el IdEstado porque no queremos mostrarlo
    Estado toEntity(EstadoDTO estadoDTO); // convertir dto a entidad para guardar en base de datos los datos que nos envian desde el cliente

}
