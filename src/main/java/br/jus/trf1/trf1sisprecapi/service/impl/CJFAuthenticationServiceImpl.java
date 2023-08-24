package br.jus.trf1.trf1sisprecapi.service.impl;

import br.jus.trf1.trf1sisprecapi.model.dto.CJFAuthenticationRequest;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerUsuarioRetorno;
import br.jus.trf1.trf1sisprecapi.service.CJFAuthenticationService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço de autenticação com a API do CJF
 *
 * @author bruno.carneiro (tr301605)
 */
@Service
public class CJFAuthenticationServiceImpl implements CJFAuthenticationService {

    private final static String CJF_AUTHENTICATION_ENDPOINT = "https://www4.cjf.jus.br/precatorios_api/ws/autenticacao/";

    private final RestTemplate restTemplate;

    @Autowired
    public CJFAuthenticationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SwaggerUsuarioRetorno cjfAuthentication(CJFAuthenticationRequest cjfAuthenticationRequest) {

        // Realizando a autentação no endpoint do CJF
        SwaggerUsuarioRetorno swaggerUsuarioRetorno = this.restTemplate.postForEntity(
                        CJF_AUTHENTICATION_ENDPOINT,
                        cjfAuthenticationRequest,
                        SwaggerUsuarioRetorno.class
                )
                .getBody();

        // Valida se a token foi retornada
        assert swaggerUsuarioRetorno != null : "A requisição não retornou o response";
        assert swaggerUsuarioRetorno.getRetorno() != null : "Erro ao obter o retorno da autenticação";
        assert Strings.isNotBlank(swaggerUsuarioRetorno.getRetorno().getToken()) : "A token de autenticação não foi retornada";

        // Adicionando a token obtida no header da requisição
        this.restTemplate.getInterceptors().add((request, body, execution) -> {
            HttpHeaders headers = request.getHeaders();
            headers.add("Authorization", "Bearer " + swaggerUsuarioRetorno.getRetorno().getToken());
            return execution.execute(request, body);
        });

        return swaggerUsuarioRetorno;
    }
}
