package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import br.jus.trf1.trf1sisprecapi.model.dto.ResponseWrapper;
import lombok.Data;

/**
 * DTO que armazena o retorno do endpoint do CJF /ws/tabela
 *
 * @author bruno.carneiro (tr301605)
 */
@Data
public class SwaggerTabelaRetorno extends ResponseWrapper<AssuntoWS[]> {

}
