package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import lombok.Data;

/**
 * Objeto de paginação do CJF
 *
 * @author bruno.carneiro
 */
@Data
public class Paginacao {
    private String [] ordenacaoCampos;
    private String [] ordenacaoTipos;
    private Integer pagina;
    private Integer registrosPorPagina;
    private Integer totalRegistros;
}
