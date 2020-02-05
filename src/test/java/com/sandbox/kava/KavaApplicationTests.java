package com.sandbox.kava;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class KavaApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Vanuatu!")));
	}

	@Test
	public void getGuid() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/guid").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$.guid").exists())
			.andExpect(jsonPath("$.guid").isString());
	}
	
	@Test
	public void getActuatorHealth() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/actuator/health").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$.status").value("UP"));
	}
}
