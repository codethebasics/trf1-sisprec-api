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
public class ValorPrecatorioWS {
    private Integer agenciaNumero;
    private Integer bancoNumero;
    private String cancelamentoData;
    private String contaDigito;
    private Integer parcelaNumero;
    private String registroData;
    private Integer sequencial;
    private ValorTipoWS valorTipoWS;
    private Float valor;
}
