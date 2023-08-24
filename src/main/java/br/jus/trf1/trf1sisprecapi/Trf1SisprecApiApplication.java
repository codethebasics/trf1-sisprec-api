package br.jus.trf1.trf1sisprecapi;

import br.jus.trf1.trf1sisprecapi.model.dto.CJFAuthenticationRequest;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerUsuarioRetorno;
import br.jus.trf1.trf1sisprecapi.service.CJFAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Objects;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
@PropertySource(value = "classpath:application-secret.properties")
public class Trf1SisprecApiApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Trf1SisprecApiApplication.class);

    @Value("${cjf.username}")
    private String cjfUsername;

    @Value("${cjf.password}")
    private String cjfPassword;

    private final CJFAuthenticationService cjfAuthenticationService;

    @Autowired
    public Trf1SisprecApiApplication(CJFAuthenticationService cjfAuthenticationService) {
        this.cjfAuthenticationService = cjfAuthenticationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Trf1SisprecApiApplication.class, args);
    }

    /**
     * Durante a inicialização da aplicação, o método abaixo será executado.
     * A ideia é solicitar uma token de autenticação ao serviço do CJF no momento da inicialização
     * da aplicação.
     *
     * Ao autenticar no endpoint do CJF, a token retornada será adicionada
     * ao header do RestTemplate, enviando o Authorization Bearer + token
     * em cada requisição subsequente
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("Realizando autenticação no endpoint do CJF...");
        SwaggerUsuarioRetorno swaggerUsuarioRetorno = this.cjfAuthenticationService.cjfAuthentication(
                CJFAuthenticationRequest
                        .builder()
                        .codigo(this.cjfUsername)
                        .senha(this.cjfPassword)
                        .build());
        if (Objects.nonNull(swaggerUsuarioRetorno)) {
            logger.info("Autenticação realizada com sucesso.");
            logger.debug("Token JWT " + swaggerUsuarioRetorno.getRetorno().getToken());
        }
    }
}
