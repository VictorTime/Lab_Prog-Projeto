package com.example.portifolio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Portifolio.model.dto.AtividadeDTO;
import com.example.Portifolio.model.entidade.Atividade;
import com.example.Portifolio.Service.AtividadeService;

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
public class AtividadeControllerTest {
	static final String api = "/api/v1/atividades/";

	@Autowired
	MockMvc mvc;

	@MockBean
	AtividadeService service;

	@Test
	/*
    MockMvc -Ponto de entrada principal para suporte de teste Spring MVC do lado do servidor 
             usa Spring Boot para isolar a camada da web e carregar um contexto de aplicativo especial

    deveSalvarAtividade(): Inspeciona as requisições e arquivos JSON 
    */
    public void deveSalvarAtividade() throws Exception {
		// cenario
		// dto para virar json
		AtividadeDTO dto = AtividadeDTO.builder().id_atv(123456L).titulo("123").resumo("abc def")
				.tipo_atv("teste").link("/abc").build();
		// resposta que será mock
		Atividade atividade = Atividade.builder().id_atv(123456L).titulo("123").resumo("abc def").build();

		// mock salvar
		Mockito.when(service.salvar(Mockito.any(Atividade.class))).thenReturn(atividade);
		String json = new ObjectMapper().writeValueAsString(dto);

		// ação
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(api).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json);

		// verificação
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
	}

}