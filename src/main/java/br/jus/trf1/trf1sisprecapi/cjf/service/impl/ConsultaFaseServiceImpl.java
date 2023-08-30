package br.jus.trf1.trf1sisprecapi.cjf.service.impl;

import br.jus.trf1.trf1sisprecapi.cjf.dto.FaseWSRequest;
import br.jus.trf1.trf1sisprecapi.cjf.dto.SwaggerFaseRetorno;
import br.jus.trf1.trf1sisprecapi.cjf.service.ConsultaFaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @see ConsultaFaseService
 * @author bruno.carneiro (tr301605)
 */
@Service
public class ConsultaFaseServiceImpl implements ConsultaFaseService {

    @Value("${cjf.ws.consulta.fase.endpoint}")
    private String CJF_FASE_CONSULTA_ENDPOINT;

    private final RestTemplate restTemplate;

    @Autowired
    public ConsultaFaseServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SwaggerFaseRetorno consultaPorFase(FaseWSRequest request) {
        final String REQUEST_URI = CJF_FASE_CONSULTA_ENDPOINT
                .replace("#faseEnum", request.getFase().getDescricao())
                .replace("#unidadeGestora", request.getUnidadeGestoraCodigo())
                .replace("#planoTipo", request.getPlanoTipo().getTipo())
                .replace("#planoMes", request.getPlanoAnoMes());
        ResponseEntity<SwaggerFaseRetorno> responseEntity = restTemplate.getForEntity(REQUEST_URI, SwaggerFaseRetorno.class);
        return responseEntity.getBody();
    }
}
