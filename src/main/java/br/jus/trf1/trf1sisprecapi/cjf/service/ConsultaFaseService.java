package br.jus.trf1.trf1sisprecapi.cjf.service;

import br.jus.trf1.trf1sisprecapi.cjf.dto.FaseWSRequest;
import br.jus.trf1.trf1sisprecapi.cjf.dto.SwaggerFaseRetorno;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface ConsultaFaseService {
    SwaggerFaseRetorno consultaPorFase(FaseWSRequest request);
}
