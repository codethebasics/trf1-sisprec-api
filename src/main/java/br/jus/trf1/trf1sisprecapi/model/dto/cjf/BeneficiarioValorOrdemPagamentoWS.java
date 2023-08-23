package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioValorOrdemPagamentoWS {

    private Integer sequencial;
    private String descricao;
    private String codigo;
    private String utilizacaoFim;
    private String observacao;
}
