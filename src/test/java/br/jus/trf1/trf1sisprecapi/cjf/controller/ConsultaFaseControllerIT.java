package br.jus.trf1.trf1sisprecapi.cjf.controller;

import br.jus.trf1.trf1sisprecapi.cjf.dto.FaseWSRequest;
import br.jus.trf1.trf1sisprecapi.cjf.enumeration.FaseEnum;
import br.jus.trf1.trf1sisprecapi.cjf.enumeration.PlanoTipoEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author bruno.carneiro (tr301605)
 */
@SpringBootTest
class ConsultaFaseControllerIT {

    private static final String ENDPOINT = "/fase";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @DisplayName("Dado parametros de uma fase, quando disparar um GET então retorna fases")
    void givenFaseWSRequest_whenConsultaFase_thenReturnHttp200() throws Exception {

        // given
        final String FASE = "ABERTA";
        final String UNIDADE_GESTORA_CODIGO = "090051";
        final String PLANO_TIPO = "rpv";
        final String PLANO_ANO_MES = "202105";

        // when / then
        this.mockMvc.perform(get(ENDPOINT
                + "/" + FASE
                + "/" + UNIDADE_GESTORA_CODIGO
                + "/plano/" + PLANO_TIPO
                + PLANO_ANO_MES))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}