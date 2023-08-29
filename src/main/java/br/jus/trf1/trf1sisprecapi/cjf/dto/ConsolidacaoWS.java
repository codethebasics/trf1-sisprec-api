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
public class ConsolidacaoWS {
    private Integer conta;
    private Integer faseSequencial;
    private Integer ordem;
    private Integer parcela;
    private String registroData;
    private Integer sequencial;
    private Float soma;
    private ConsolidacaoTipo tipo;
}
