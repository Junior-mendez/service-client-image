package com.co.pragma.serviceclienteimagen.application.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.co.pragma.serviceclienteimagen.domain.service.ClientImageService;
import com.co.pragma.serviceclienteimagen.helpers.ClientImageHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@WebMvcTest
class ClientImageControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ClientImageService clientImageService;
	
	static ObjectMapper om = new ObjectMapper();
	@BeforeEach
	  public void setUp() throws Exception {
	    om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    JacksonTester.initFields(this, om);
	  }
	
	@Test
	void testCreateClientImage() throws Exception  {
		when(clientImageService.create(Mockito.any())).thenReturn(ClientImageHelper.createClientImage());

		mockMvc.perform(
				post("/image/create")
				.content(om.writeValueAsBytes(ClientImageHelper.createClientImageRequest()))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	@Test
	void testUpdateClientImage() throws Exception  {
		when(clientImageService.update(Mockito.any())).thenReturn(ClientImageHelper.createClientImage());

		mockMvc.perform(
				post("/image/update")
				.content(om.writeValueAsBytes(ClientImageHelper.createClientImageRequest()))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Test
	void testGetClientImage() throws Exception  {
		when(clientImageService.getImage(Mockito.anyString())).thenReturn(ClientImageHelper.createClientImage());

		mockMvc.perform(
				get("/image/{id}","DNI76515667"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}
	

}
