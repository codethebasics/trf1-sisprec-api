package br.jus.trf1.trf1sisprecapi;

import br.jus.trf1.trf1sisprecapi.config.beans.BeansConfiguration;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerUsuarioRetorno;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.TokenWS;
import br.jus.trf1.trf1sisprecapi.service.CJFAuthenticationService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Objects;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
public class Trf1SisprecApiApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trf1SisprecApiApplication.class);

    private final CJFAuthenticationService cjfAuthenticationService;

    public Trf1SisprecApiApplication(CJFAuthenticationService cjfAuthenticationService) {
        this.cjfAuthenticationService = cjfAuthenticationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Trf1SisprecApiApplication.class, args);
    }

    /**
     * No momento em que a aplicação ser iniciada, a autenticação
     * junto ao serviço do CJF será requisitada com as credenciais
     * cadastradas no arquivo application-secret.properties
     *
     * Uma vez autenticado, a token de autenticação recebida será armazenada
     * e disponibilizada através da variável estática BeansConfiguration.jwtToken
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        ///////////////////////////////////////////////////////////////
        LOGGER.info("Realizando autenticação com o serviço do CJF...");
        ///////////////////////////////////////////////////////////////

        SwaggerUsuarioRetorno response = this.cjfAuthenticationService.cjfAuthentication();

        final boolean hasResponseBody = Objects.nonNull(response) && Objects.nonNull(response.getRetorno());
        if (hasResponseBody) {
            TokenWS token = response.getRetorno();

            if (Strings.isNotBlank(token.getToken())) {
                LOGGER.info("");
                LOGGER.info("Autenticação realizada com sucesso!");
                LOGGER.debug(token.getToken());
                LOGGER.info("");

                BeansConfiguration.jwtToken = token.getToken();
            }
        }
    }
}
