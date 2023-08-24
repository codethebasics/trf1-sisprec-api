package br.jus.trf1.trf1sisprecapi.service.impl;

import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerTabelaRetorno;
import br.jus.trf1.trf1sisprecapi.service.ConsultaTabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @see br.jus.trf1.trf1sisprecapi.service.ConsultaTabelaService
 * @author bruno.carneiro (tr301605)
 */
@Service
public class ConsultaTabelaServiceImpl implements ConsultaTabelaService {

    private final static String CJF_TABELA_ENDPOINT = "https://www4.cjf.jus.br/ws/itens/tabela/";

    private final RestTemplate restTemplate;

    @Autowired
    public ConsultaTabelaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SwaggerTabelaRetorno getTabelaItens(String tabela) {
        final String REQUEST_URI = CJF_TABELA_ENDPOINT + tabela;
        return this.restTemplate.getForEntity(
                REQUEST_URI,
                SwaggerTabelaRetorno.class
        )
        .getBody();
    }

    @Override
    public SwaggerTabelaRetorno getTabelaItem(String tabela, Long codigo) {
        final String REQUEST_URI = CJF_TABELA_ENDPOINT + tabela + "/" + codigo;
        return this.restTemplate.getForEntity(
                        REQUEST_URI,
                        SwaggerTabelaRetorno.class
                )
                .getBody();
    }
}
