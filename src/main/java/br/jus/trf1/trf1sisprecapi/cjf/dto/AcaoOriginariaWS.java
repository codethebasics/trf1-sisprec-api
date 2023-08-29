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
public class AcaoOriginariaWS {
    private String ajuizamentoData;
    private String numero;
    private Integer sequencial;
    private UnidadeJudicialWS unidadeJudicial;
    private UnidadeJudicialWS[] unidadesJudiciais;
}
