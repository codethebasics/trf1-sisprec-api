package br.jus.trf1.trf1sisprecapi.controller;

import br.jus.trf1.trf1sisprecapi.cjf.dto.CJFAuthenticationRequest;
import br.jus.trf1.trf1sisprecapi.cjf.dto.UnidadeSuperiorWS;
import br.jus.trf1.trf1sisprecapi.util.JSONParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testes de integração do serviço de autenticação do SIREA e CJF
 *
 * @author bruno.carneiro (tr301605)
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:application-secret.properties")
class AuthControllerIT {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Value("${cjf.username}")
    private String cjfUsername;

    @Value("${cjf.password}")
    private String cjfPassword;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    /**
     * Tendo em vista que a autenticação depende do serviço do CJF,
     * o teste será desabilitado em virtude das eventuais indisponibilidades
     * da API de autenticação do CJF
     */
    @Disabled
    @Test
    @DisplayName("Quando acessar a rota '/auth/cjf passando as credenciais, então retorna 200")
    void whenGetIndexRoute_thenReturnHttp403() throws Exception {
        this.mockMvc.perform(
                post("/auth/cjf")
                        .content(JSONParser.asJsonString(
                                CJFAuthenticationRequest.builder()
                                        .codigo(cjfUsername)
                                        .senha(cjfPassword)
                                        .build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Acesso concedido")));
    }
}