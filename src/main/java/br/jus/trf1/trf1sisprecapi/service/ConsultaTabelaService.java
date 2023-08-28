package br.jus.trf1.trf1sisprecapi.service;

import br.jus.trf1.trf1sisprecapi.model.dto.ResponseWrapper;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.AssuntoWS;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerTabelaRetorno;
import org.springframework.http.ResponseEntity;

/**
 * Serviço responsável pela integração com o endpoint de tabela do CJF
 * 
 * @author bruno.carneiro (tr301605)
 */
public interface ConsultaTabelaService {

    /**
     * Solicita a listagem dos itens da tabela informada à API do CJF
     *
     * @param tabela tabela a ser consultada
     * @return lista de itens presentes na tabela
     *
     * @throws Exception
     */
    SwaggerTabelaRetorno getTabelaItens(String tabela) throws Exception;

    /**
     * Solicita o item de uma tabela à API do CJF à partir de seu código
     *
     * @param tabela tabela a ser consultada
     * @param codigo código do item a ser consultado
     * @return item
     *
     * @throws Exception
     */
    SwaggerTabelaRetorno  getTabelaItem(String tabela, String codigo) throws Exception;
}
