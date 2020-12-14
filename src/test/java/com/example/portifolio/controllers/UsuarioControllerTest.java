package com.example.portifolio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Portifolio.model.dto.UsuarioDTO;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.Service.UsuarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UsuarioControllerTest {
	static final String api = "/api/v1/usuarios/";

	@Autowired
	MockMvc mvc;

	@MockBean
	UsuarioService service;

	@Test
	/*
    MockMvc -Ponto de entrada principal para suporte de teste Spring MVC do lado do servidor 
             usa Spring Boot para isolar a camada da web e carregar um contexto de aplicativo especial

    deveSalvarUsuario(): Inspeciona as requisições e arquivos JSON 
    */
	public void deveSalvarUsuario() throws Exception {
		// cenario
		// dto para virar json
		UsuarioDTO dto = UsuarioDTO.builder().matricula(123456L).senha("123").nome("abc")
				.email("abc@gmail.com").tipo(1).build();
		// resposta que será mock
		Usuario usuario = Usuario.builder().matricula(123L).nome("abc").email("abc@gmail.com")
				.senha("123").build();

		// mock salvar
		Mockito.when(service.salvar(Mockito.any(Usuario.class))).thenReturn(usuario);
		String json = new ObjectMapper().writeValueAsString(dto);

		// ação
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(api).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json);

		// verificação
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
	}

}