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
public class UnidadeTipoWS {
    private String codigo;
    private String descricao;
    private String natureza;
    private Integer sequencial;
    private String utilizacaoFim;
}
