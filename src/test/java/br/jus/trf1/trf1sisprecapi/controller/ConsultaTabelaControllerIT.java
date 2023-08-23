package br.jus.trf1.trf1sisprecapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * Testes de integração do serviço de consulta de tabelas do CJF
 *
 * @author bruno.carneiro (tr301605)
 */
@SpringBootTest
class ConsultaTabelaControllerIT {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @DisplayName("Dado a tabela assunto, quando disparar um GET então retorna itens do assunto")
    void givenTabela_whenGetOnTabelaEndpoint_thenReturnItens() {
        // given

        // when

        // then
    }
}