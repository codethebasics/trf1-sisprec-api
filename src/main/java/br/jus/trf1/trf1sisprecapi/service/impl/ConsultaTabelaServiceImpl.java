package br.jus.trf1.trf1sisprecapi.service.impl;

import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerTabelaRetorno;
import br.jus.trf1.trf1sisprecapi.service.ConsultaTabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @see br.jus.trf1.trf1sisprecapi.service.ConsultaTabelaService
 * @author bruno.carneiro (tr301605)
 */
@Service
public class ConsultaTabelaServiceImpl implements ConsultaTabelaService {

    @Value("${cjf.ws.consulta.tabela.endpoint}")
    private String CJF_TABELA_ENDPOINT_TABELA;

    @Value("${cjf.ws.consulta.tabela.codigo.endpoint}")
    private String CJF_TABELA_ENDPOINT_TABELA_CODIGO;

    private final RestTemplate restTemplate;

    @Autowired
    public ConsultaTabelaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SwaggerTabelaRetorno getTabelaItens(String tabela) {
        final String REQUEST_URI = CJF_TABELA_ENDPOINT_TABELA.replace("#tabela", tabela);
        ResponseEntity<SwaggerTabelaRetorno> responseEntity = restTemplate.getForEntity(REQUEST_URI, SwaggerTabelaRetorno.class);
        return responseEntity.getBody();
    }

    @Override
    public SwaggerTabelaRetorno getTabelaItem(String tabela, String codigo) throws Exception {
        final String REQUEST_URI = CJF_TABELA_ENDPOINT_TABELA_CODIGO
                .replace("#tabela", tabela)
                .replace("#codigo", codigo);
        ResponseEntity<SwaggerTabelaRetorno> responseEntity = restTemplate.getForEntity(REQUEST_URI, SwaggerTabelaRetorno.class);
        return responseEntity.getBody();
    }
}
