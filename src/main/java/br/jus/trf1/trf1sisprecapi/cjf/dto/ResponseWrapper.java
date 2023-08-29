package br.jus.trf1.trf1sisprecapi.cjf.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

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
    private HttpStatus status;
    private Integer statusCode;
    private String[] mensagens;
    private Paginacao paginacao;
    private T retorno;

}
