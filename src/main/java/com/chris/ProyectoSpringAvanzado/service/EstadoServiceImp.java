package com.chris.ProyectoSpringAvanzado.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chris.ProyectoSpringAvanzado.exception.RecursoNoEncontradoException;
import com.chris.ProyectoSpringAvanzado.model.Estado;
import com.chris.ProyectoSpringAvanzado.repository.EstadoRepository;

@Service
public class EstadoServiceImp implements EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoServiceImp(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;

    }

    @Override
    public Estado saveEstado(Estado estado) {

        return estadoRepository.save(estado);

    }

    @Override
    public Estado getIdEstado(Long idEstado) {
        Estado estado = estadoRepository.findById(idEstado)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estado no encontrado con el id: " + idEstado)

                );

        return estado;

    }

    @Override
    public List<Estado> getAllEstado() {

        return estadoRepository.findAll();

    }

    @Override
    public Estado updateEstado(Long idEstado, Estado estado) {
        Estado estadoActualizar = estadoRepository.findById(idEstado)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estado no encontrado"));

        estadoActualizar.setNombre(estado.getNombre());

        return estadoRepository.save(estadoActualizar);

    }

    @Override
    public void deleteEstado(Long id) {

        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estado no encontrado"));

        estadoRepository.delete(estado);

    }

}
