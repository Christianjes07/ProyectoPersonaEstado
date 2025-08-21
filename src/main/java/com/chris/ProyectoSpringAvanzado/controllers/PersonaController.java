package com.chris.ProyectoSpringAvanzado.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.ProyectoSpringAvanzado.dto.PersonaDTO;
import com.chris.ProyectoSpringAvanzado.model.Persona;
import com.chris.ProyectoSpringAvanzado.service.PersonaService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;

    }

    @PostMapping("/agregar")
    public ResponseEntity<Persona> guardarPersona(@RequestBody @Valid Persona persona) {
        Persona personaGuardada = personaService.savePersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaGuardada);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<Persona>> mostrarPersonas() {

        List<Persona> listaPersonas = personaService.getAllPersonas();
        return ResponseEntity.ok(listaPersonas);

    }

    @PutMapping("/editar/{idPersona}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long idPersona, @RequestBody @Valid Persona persona) {

        Persona personaAct = personaService.updatePersona(idPersona, persona);
        return ResponseEntity.ok(personaAct);

    }

    @DeleteMapping("/eliminar/{idPersona}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long idPersona) {
        personaService.deletePersona(idPersona);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/mostrar/{idPersona}")
    public ResponseEntity<Persona> mostrarPersonaId(@PathVariable Long idPersona) {
        Persona persona = personaService.getIdPersona(idPersona);
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/listar")
    public ResponseEntity <List<PersonaDTO>> listarPersonas(){
        List <PersonaDTO> personaListar = personaService.listaPersonas();
        return ResponseEntity.ok(personaListar);
    }

}
