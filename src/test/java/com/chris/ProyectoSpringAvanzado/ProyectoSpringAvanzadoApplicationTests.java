package com.chris.ProyectoSpringAvanzado;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.chris.ProyectoSpringAvanzado.model.Estado;
import com.chris.ProyectoSpringAvanzado.model.Persona;
import com.chris.ProyectoSpringAvanzado.repository.EstadoRepository;
import com.chris.ProyectoSpringAvanzado.repository.PersonaRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ProyectoSpringAvanzadoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	private Estado estado;

	@BeforeEach
	void setup() {
		

		estado = new Estado();
		estado.setNombre("Jalisco");
		estado = estadoRepository.save(estado);

		Persona persona = new Persona();
		persona.setNombre("Christian");
		persona.setEmail("christian@example.com");
		persona.setFechaNacimiento(LocalDate.of(1995, 3, 15));
		persona.setEstado(estado);
		personaRepository.save(persona);
	}

	@Test
	@WithMockUser(username = "admin", roles = { "ADMIN" })

	void testListarPersonas() throws Exception {
		mockMvc.perform(get("/api/personas/mostrar"))
				.andExpect(status().isOk());
	}
}