package br.jus.trf1.trf1sisprecapi.cjf.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassificacaoDespesaWS {

    private Integer sequencial;
    private String naturezaDespesaDescricao;
    private String despesaTipoCodigo;
    private String despesaTipoDescricao;
    private Boolean alimentar;
    private Integer despesaTipoSequencial;
    private String utilizacaoInicioData;
    private String utilizacaoFimData;
    private String naturezaDespesaCodigo;
}
