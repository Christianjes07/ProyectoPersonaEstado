package com.chris.ProyectoSpringAvanzado;

import com.chris.ProyectoSpringAvanzado.controllers.PersonaController;
import com.chris.ProyectoSpringAvanzado.dto.PersonaDTO;
import com.chris.ProyectoSpringAvanzado.model.Estado;
import com.chris.ProyectoSpringAvanzado.model.Persona;
import com.chris.ProyectoSpringAvanzado.service.PersonaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;

@WebMvcTest(PersonaController.class)
class PersonaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonaService personaService;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void testGetPersonaById() throws Exception {
        // 👈 Creamos el DTO, que es lo que el endpoint realmente devuelve
        PersonaDTO personaDTO = new PersonaDTO(3L, "Juan", "Jalisco");

        // 👈 Mockeamos el método del service que devuelve el DTO
        when(personaService.listarPersonaDTOs(3L))
                .thenReturn(personaDTO);

        mockMvc.perform(get("/api/personas/listar/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.nombreEstado").value("Jalisco"));
    }

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    void testGetPersonaId() throws Exception {

        Persona persona1 = new Persona(
                1L,
                "Christian",
                "christian@example.com",
                LocalDate.of(1995, 3, 15),
                new Estado(1L, "Jalisco"));

        Persona persona2 = new Persona(
                1L,
                "Christian",
                "christian@example.com",
                LocalDate.of(1995, 3, 15),
                new Estado(1L, "Jalisco"));

        Persona persona3 = new Persona(
                3L,
                "Juan",
                "Juan@gmail.com",
                LocalDate.of(1995, 8, 15),
                new Estado(1L, "Jalisco"));
        when(personaService.getIdPersona(3L)).thenReturn(persona3);

        mockMvc.perform(get("/api/personas/listarid/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPersona").value(3L))
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.email").value("Juan@gmail.com"))
                .andExpect(jsonPath("$.fechaNacimiento").value("1995-08-15"))
                .andExpect(jsonPath("$.estado.idEstado").value(1))
                .andExpect(jsonPath("$.estado.nombre").value("Jalisco"));

    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void testAllPersonas() throws Exception {
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
        when(personaService.getAllPersonas()).thenReturn(lista);
        mockMvc.perform(get("/api/personas/mostrar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idPersona").value(10L))
                .andExpect(jsonPath("$[0].nombre").value("Christian"))
                 .andExpect(jsonPath("$[0].email").value("christian@example.com"))
                .andExpect(jsonPath("$[0].fechaNacimiento").value("1995-03-15"))
                .andExpect(jsonPath("$[0].estado.idEstado").value(1))
                .andExpect(jsonPath("$[0].estado.nombre").value("Jalisco"))
                .andExpect(jsonPath("$[1].idPersona").value(20L))
                .andExpect(jsonPath("$[1].nombre").value("Christian"))
                 .andExpect(jsonPath("$[1].email").value("christian@example.com"))
                .andExpect(jsonPath("$[1].fechaNacimiento").value("1995-03-15"))
                .andExpect(jsonPath("$[1].estado.idEstado").value(1))
                .andExpect(jsonPath("$[1].estado.nombre").value("Jalisco"));
                

    }

}