package br.jus.trf1.trf1sisprecapi.model.dto;

import br.jus.trf1.trf1sisprecapi.model.dto.cjf.Paginacao;
import lombok.*;

/**
 * Wrapper do response das APIs do CJF
 * @param <T>
 *
 * @author bruno.carneiro
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {
    private String status;
    private Integer statusCode;
    private String[] mensagens;
    private Paginacao paginacao;
    private T retorno;

}