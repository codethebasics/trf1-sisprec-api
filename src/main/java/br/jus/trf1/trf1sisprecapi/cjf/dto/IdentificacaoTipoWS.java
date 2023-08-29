package br.jus.trf1.trf1sisprecapi.cjf.dto;

import lombok.*;

/**
 * @author bruno.carneiro (tr301605)
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentificacaoTipoWS {
    private String codigo;
    private String descricao;
    private Integer sequencial;
    private String utilizacaoFim;
}
