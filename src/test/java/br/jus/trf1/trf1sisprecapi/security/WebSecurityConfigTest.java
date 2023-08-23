package br.jus.trf1.trf1sisprecapi.security;

import br.jus.trf1.trf1sisprecapi.model.dto.SireaAuthRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testes de integração da camada de segurança
 *
 * @author bruno.carneiro
 */
@SpringBootTest
class WebSecurityConfigTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PasswordEncoder encoder;

    private MockMvc mockMvc;

    private static ObjectMapper mapper;
    private static ObjectWriter writer;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        writer = mapper.writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @DisplayName("Quando acessar a rota '/' então retorna FORBIDDEN")
    void whenGetIndexRoute_thenReturnHttp403() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Quando acessar a rota '/auth' então retorna OK")
    void whenActuatorRoute_thenReturnHttp200() throws Exception {
        String jsonRequest = writer.writeValueAsString(
                new SireaAuthRequest("00825346169", "senhasirea"));

        this.mockMvc.perform(
                post("/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Quando requisitar um POST na rota '/system' então retorna FORBIDDEN")
    void whenPostSystemRoute_thenReturnHttp403() throws Exception {
        this.mockMvc.perform(post("/system", ""))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Dado um usuário comum, quando requisitar um POST na rota '/system' então retorna FORBIDDEN")
    @WithMockUser(username = "spring", roles = "USER")
    void givenCommonUser_whenPostSystemRoute_thenReturnHttp403() throws Exception {
        this.mockMvc.perform(post("/system"))
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("Dado um usuário administrador, quando requisitar um POST na rota '/system' então retorna OK")
    @WithMockUser(username = "spring", roles = "ADMIN")
    void givenAdminUser_whenPostSystemRoute_thenReturnHttp200() throws Exception {
        this.mockMvc.perform(post("/system"))
                .andExpect(status().isOk());
    }
}