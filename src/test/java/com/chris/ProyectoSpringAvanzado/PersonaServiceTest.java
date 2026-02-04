package com.chris.ProyectoSpringAvanzado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.chris.ProyectoSpringAvanzado.model.Estado;
import com.chris.ProyectoSpringAvanzado.model.Persona;
import com.chris.ProyectoSpringAvanzado.repository.PersonaRepository;
import com.chris.ProyectoSpringAvanzado.service.PersonaServiceImp;

public class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaServiceImp personaServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarPersonaPorId() {

        Persona persona1 = new Persona(
                10L,
                "Christian",
                "christian@example.com",
                LocalDate.of(1995, 3, 15),
                new Estado(1L, "Jalisco"));

        Persona persona2 = new Persona(
                20L,
                "Christian",
                "christian@example.com",
                LocalDate.of(1995, 3, 15),
                new Estado(1L, "Jalisco"));

        when(personaRepository.findById(10L)).thenReturn(Optional.of(persona1));
        Persona result = personaServiceImp.getIdPersona(10L);
        assertEquals(persona1, result);
        assertEquals("Christian", persona1.getNombre());
    }

    @Test
    void testMostrarTodasLasPersonas() {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        Persona persona1 = new Persona(
                10L,
                "Christian",
                "christian@example.com",
                LocalDate.of(1995, 3, 15),
                new Estado(1L, "Jalisco"));

        Persona persona2 = new Persona(
                20L,
                "Christian",
                "christian@example.com",
                LocalDate.of(1995, 3, 15),
                new Estado(1L, "Jalisco"));

        lista.add(persona1);
        lista.add(persona2);
        when(personaRepository.findAll()).thenReturn(lista);
        List<Persona> resultado = personaServiceImp.getAllPersonas();
        assertEquals(lista, resultado);
    
    }

}
