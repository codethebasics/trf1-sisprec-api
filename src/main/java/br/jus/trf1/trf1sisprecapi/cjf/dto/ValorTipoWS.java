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
public class ValorTipoWS {
    private String codigo;
    private String contextoUtilizacaoCodigo;
    private String descricao;
    private String observacao;
    private String processoBeneficiarioCodigo;
    private Integer sequencial;
    private String utilizacaoFim;
}
