package br.jus.trf1.trf1sisprecapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


/**
 * Testes de integração do serviço de consulta de tabelas do CJF
 *
 * @author bruno.carneiro (tr301605)
 */
@SpringBootTest
class ConsultaTabelaControllerIT {

    private static final String ENDPOINT = "/tabela/itens";

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
    @WithMockUser(username = "spring", roles = "USER")
    void givenTabela_whenGetOnTabelaEndpoint_thenReturn200() throws Exception {

        // given
        final String tabela = "/assunto";

        // when / then
        this.mockMvc.perform(get(ENDPOINT + tabela))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}