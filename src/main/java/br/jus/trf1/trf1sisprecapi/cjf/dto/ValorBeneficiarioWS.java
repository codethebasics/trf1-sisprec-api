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
public class ValorBeneficiarioWS {
    private Integer agenciaNumero;
    private Integer bancoNumero;
    private Integer beneficiarioSequencial;
    private String contaCodigo;
    private String debitoIndentificacao;
    private Integer documentoTipo;
    private String eventoData;
    private OrdemPagamento107ATipoWS ordemPagamento107ATipo;
    private Integer parcelaNumero;
    private String receitaCodigo;
    private Integer sequencial;
    private ValorTipoWS tipo;
    private Float valor;

}
