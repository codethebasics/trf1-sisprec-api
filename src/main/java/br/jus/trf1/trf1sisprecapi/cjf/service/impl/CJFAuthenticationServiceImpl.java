package br.jus.trf1.trf1sisprecapi.cjf.service.impl;

import br.jus.trf1.trf1sisprecapi.Trf1SisprecApiApplication;
import br.jus.trf1.trf1sisprecapi.cjf.dto.CJFAuthenticationRequest;
import br.jus.trf1.trf1sisprecapi.cjf.dto.SwaggerUsuarioRetorno;
import br.jus.trf1.trf1sisprecapi.cjf.service.CJFAuthenticationService;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço de autenticação com a API do CJF
 *
 * @author bruno.carneiro (tr301605)
 */
@Service
@PropertySource(value = "classpath:application-secret.properties")
public class CJFAuthenticationServiceImpl implements CJFAuthenticationService {

    private final static String CJF_AUTHENTICATION_ENDPOINT = "https://www4.cjf.jus.br/precatorios_api/ws/autenticacao/";

    private final RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(Trf1SisprecApiApplication.class);

    @Value("${cjf.username}")
    private String cjfUsername;

    @Value("${cjf.password}")
    private String cjfPassword;

    @Autowired
    public CJFAuthenticationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SwaggerUsuarioRetorno cjfAuthentication() {

        logger.info("Realizando autenticação no endpoint do CJF");

        SwaggerUsuarioRetorno swaggerUsuarioRetorno = this.restTemplate.postForEntity(
                        CJF_AUTHENTICATION_ENDPOINT,
                        new CJFAuthenticationRequest(this.cjfUsername, this.cjfPassword),
                        SwaggerUsuarioRetorno.class
                )
                .getBody();

        // Valida se a token foi retornada
        assert swaggerUsuarioRetorno != null : "A requisição não retornou o response";
        assert swaggerUsuarioRetorno.getRetorno() != null : "Erro ao obter o retorno da autenticação";
        assert Strings.isNotBlank(swaggerUsuarioRetorno.getRetorno().getToken()) : "A token de autenticação não foi retornada";

        return swaggerUsuarioRetorno;
    }
}
