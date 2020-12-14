package com.example.portifolio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Portifolio.model.dto.CurriculoDTO;
import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.Service.CurriculoService;

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
public class CurriculoControllerTest {
	static final String api = "/api/v1/curriculo/";

	@Autowired
	MockMvc mvc;

	@MockBean
	CurriculoService service;

	@Test
	/*
    MockMvc -Ponto de entrada principal para suporte de teste Spring MVC do lado do servidor 
             usa Spring Boot para isolar a camada da web e carregar um contexto de aplicativo especial

    deveSalvarCurriculo(): Inspeciona as requisições e arquivos JSON 

    */
    public void deveSalvarCurriculo() throws Exception {
		// cenario
		// dto para virar json
		CurriculoDTO dto = CurriculoDTO.builder().id_curriculo(123456L).escolaridade("Superior").formacao("adjudeba").build();
		// resposta que será mock
		Curriculo curriculo = Curriculo.builder().id_curriculo(123456L).build();

		// mock salvar
		Mockito.when(service.salvar(Mockito.any(Curriculo.class))).thenReturn(curriculo);
		String json = new ObjectMapper().writeValueAsString(dto);

		// ação
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(api).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json);

		// verificação
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
	}

}