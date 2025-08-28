package com.chris.ProyectoSpringAvanzado.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.ProyectoSpringAvanzado.dto.EstadoDTO;
import com.chris.ProyectoSpringAvanzado.model.Estado;
import com.chris.ProyectoSpringAvanzado.service.EstadoService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;

    }

    @PostMapping("/crear")
    public ResponseEntity<Estado> postEstado(@RequestBody @Valid Estado estado) {

        estadoService.saveEstado(estado);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<Estado>> getEstado() {
        List<Estado> listaEstado = estadoService.getAllEstado();
        return ResponseEntity.ok(listaEstado);
    }

    @PutMapping("editar/{idEstado}")
    public ResponseEntity<Estado> putMostrarId(@PathVariable Long idEstado, @RequestBody @Valid Estado estado) {

        estadoService.updateEstado(idEstado, estado);
        return ResponseEntity.ok().body(estado);
    }

    @DeleteMapping("eliminar/{idEstado}")
    public ResponseEntity<Void> deleteEliminarEstado(@PathVariable Long idEstado) {

        estadoService.deleteEstado(idEstado);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/listar")
    public ResponseEntity<List<EstadoDTO>> listarEstados() {

        List<EstadoDTO> listarDTOS = estadoService.listarEstadoDTOs();
        return ResponseEntity.ok(listarDTOS);
    }

    @GetMapping("/listar/{idEstado}")
    public ResponseEntity<EstadoDTO> listarEstadosDTOS(@PathVariable Long idEstado) {

        EstadoDTO estadoDTO = estadoService.listarEstados(idEstado);
        return ResponseEntity.ok().body(estadoDTO);

    }

    @GetMapping("/mostrar/{idEstado}")
    public ResponseEntity<Estado> getIdEstado(@PathVariable Long idEstado) {
        Estado estado = estadoService.getIdEstado(idEstado);
        return ResponseEntity.ok().body(estado);

    }

    @GetMapping("/listarMapper")
    public ResponseEntity<List<EstadoDTO>> getListMapper() {

        List<EstadoDTO> listaMapper = estadoService.listarEstadosMapper();

        return ResponseEntity.ok().body(listaMapper);
    }

}
