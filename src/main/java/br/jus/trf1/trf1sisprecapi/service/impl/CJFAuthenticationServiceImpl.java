package br.jus.trf1.trf1sisprecapi.service.impl;

import br.jus.trf1.trf1sisprecapi.model.dto.CJFAuthenticationRequest;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerUsuarioRetorno;
import br.jus.trf1.trf1sisprecapi.service.CJFAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço de autenticação com o serviço do CJF
 *
 * @author bruno.carneiro
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
        return this.restTemplate.postForEntity(
                        CJF_AUTHENTICATION_ENDPOINT,
                        cjfAuthenticationRequest,
                        SwaggerUsuarioRetorno.class
                )
                .getBody();
    }
}
