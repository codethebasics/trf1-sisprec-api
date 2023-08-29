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
public class BeneficiarioWS {
    private Boolean advogadoCausa;
    private BeneficiarioAntecessorWS[] antecessores;
    private BeneficiarioTipoWS beneficiarioTipo;
    private String cancelamentoData;
    private String codigoBeneficiarioCompensacaoGPS;
    private String compensacaoData;
    private Integer competenciaExpedicaoAno;
    private CondicaoServidorTipoWS condicaoServidorTipo;
    private ContaBancaria contaBancaria;
    private Integer exercicioAnteriorNumeroMeses;
    private Integer exercicioCorrenteNumeroMeses;
    private IdentificacaoTipoWS indentificacaoTipo;
    private String intimacaoData;
    private Boolean isentoIRRF;
    private MovimentoTipoWS movimentoTipo;
    private String nascimentoData;
    private PessoaWS pessoa;
    private Boolean portadorDeficiencia;
    private Boolean portadorDoencaGrave;
    private String registroData;
    private Integer sequencial;
    private UnidadeWS unidade;
    private ValorBeneficiarioWS[] valores;
}
