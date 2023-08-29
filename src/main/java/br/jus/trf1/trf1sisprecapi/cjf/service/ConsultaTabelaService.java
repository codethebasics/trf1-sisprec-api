package br.jus.trf1.trf1sisprecapi.cjf.service;

import br.jus.trf1.trf1sisprecapi.cjf.dto.SwaggerTabelaRetorno;

/**
 * @author bruno.carneiro (tr301605)
 */
public interface ConsultaTabelaService {
    SwaggerTabelaRetorno getTabelaItens(String tabela) throws Exception;
    SwaggerTabelaRetorno getTabelaItem(String tabela, String codigo) throws Exception;
}
