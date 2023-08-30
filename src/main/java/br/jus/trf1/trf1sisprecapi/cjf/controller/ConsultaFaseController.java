package br.jus.trf1.trf1sisprecapi.cjf.controller;

import br.jus.trf1.trf1sisprecapi.cjf.dto.FaseWSRequest;
import br.jus.trf1.trf1sisprecapi.cjf.dto.SwaggerFaseRetorno;
import br.jus.trf1.trf1sisprecapi.cjf.enumeration.FaseEnum;
import br.jus.trf1.trf1sisprecapi.cjf.enumeration.PlanoTipoEnum;
import br.jus.trf1.trf1sisprecapi.cjf.service.ConsultaFaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsável pela interação com a API de consulta de fases do CJF
 *
 * Para consultar o Swagger do CJF, favor acessar
 * <a href="https://www4.cjf.jus.br/precatorios_api/swagger/swagger-ui.html#">https://www4.cjf.jus.br/precatorios_api/swagger/swagger-ui.html#</a>
 *
 * @author bruno.carneiro (tr301605)
 */
@RestController
@RequestMapping("/tabela")
public class ConsultaFaseController {

    private final ConsultaFaseService consultaFaseService;

    @Autowired
    public ConsultaFaseController(ConsultaFaseService consultaFaseService) {
        this.consultaFaseService = consultaFaseService;
    }

    @GetMapping("/fase/{fase}/{unidadeGestoraCodigo}/plano/{planoTipo}/{planoMes}")
    public SwaggerFaseRetorno getFase(
            @PathVariable("fase") String fase,
            @PathVariable("unidadeGestoraCodigo") String unidadeGestoraCodigo,
            @PathVariable("planoTipo") String planoTipo,
            @PathVariable("planoAnoMes") String planoAnoMes) {

        FaseEnum faseEnum;

        switch (fase.toUpperCase()) {
            case "ABERTA": faseEnum = FaseEnum.ABERTA; break;
            case "FECHADA": faseEnum = FaseEnum.FECHADA; break;
            default: faseEnum = FaseEnum.TODAS;
        }

        PlanoTipoEnum planoTipoEnum;

        switch (planoTipo.toUpperCase()) {
            case "PCT": planoTipoEnum = PlanoTipoEnum.PCT; break;
            default: planoTipoEnum = PlanoTipoEnum.RPV;
        }

        SwaggerFaseRetorno fases = this.consultaFaseService
                .consultaPorFase(FaseWSRequest.builder()
                        .fase(faseEnum)
                        .unidadeGestoraCodigo(unidadeGestoraCodigo)
                        .planoTipo(planoTipoEnum)
                        .planoAnoMes(planoAnoMes)
                        .build());

        return ResponseEntity
                .status(fases.getStatus())
                .body(fases)
                .getBody();
    }
}
