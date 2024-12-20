package edu.mx.utdelacosta;


import edu.mx.utdelacosta.controllers.LenguajesProgramacionController;

import edu.mx.utdelacosta.entity.LenguajesProgramacion;
import edu.mx.utdelacosta.services.LenguajesProgramacionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LenguajesProgramacionController.class)
@ActiveProfiles("test")
class BackendJava02ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockitoBean
	private LenguajesProgramacionService lenguajesService;

	@Test
	public void testGetLenguajesOne() throws Exception {
		mvc.perform(get("http://localhost:8080/api/v2/lenguajes-programacion"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetLenguajes() throws Exception {
		when(lenguajesService.listaLenguajes()).thenReturn(List.of(
				new LenguajesProgramacion(3, "Phyton"),
				new LenguajesProgramacion(4, "JS")
		));
		mvc.perform(get("http://localhost:8080/api/v2/lenguajes-programacion"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("""
						{
						    "head": "Lista de lenguajes",
						    "body": [
						        {
						            "id": 3,
						            "nombre": "Phyton"
						        },
						        {
						            "id": 4,
						            "nombre": "JS"
						        }
						    ]
						}
						"""));

	}

}
