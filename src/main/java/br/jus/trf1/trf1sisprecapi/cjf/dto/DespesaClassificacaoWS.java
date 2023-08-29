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
public class DespesaClassificacaoWS {
    private Boolean alimentar;
    private String despesaTipoCodigo;
    private String despesaTipoDescricao;
    private Integer despesaTipoSequencial;
    private String naturezaDespesaCodigo;
    private String naturezaDespesaDescricao;
    private Integer sequencial;
    private String utilizacaoFimData;
    private String utilizacaoInicioData;
}
