package com.chris.ProyectoSpringAvanzado.service;

import java.util.List;

import com.chris.ProyectoSpringAvanzado.dto.EstadoDTO;
import com.chris.ProyectoSpringAvanzado.model.Estado;

public interface EstadoService {

    Estado saveEstado(Estado estado);

    Estado getIdEstado(Long idEstado);

    List<Estado> getAllEstado();

    Estado updateEstado(Long idEstado, Estado estado);

    void deleteEstado(Long id);

    // con metodo
    EstadoDTO listarEstados(Long idEstado);

    // con stream

    List<EstadoDTO> listarEstadoDTOs();


    List<EstadoDTO> listarEstadosMapper();
    

}
