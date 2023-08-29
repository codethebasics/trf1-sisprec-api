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
public class FaseWS {
    private Boolean aberta;
    private String aberturaData;
    private Integer ano;
    private Integer anoExercicioOrcamentario;
    private String cancelamentoData;
    private String codSufixoProcessoSiaf;
    private Consolidacao[] consolidacoes;
    private String descricao;
    private String exclusaoData;
    private FaseTipo faseTipo;
    private String fechamentoData;
    private String fimExclusaoData;
    private Integer mes;
    private Plano plano;
    private Boolean processosIndicadosParaPagamentoEnviarExcluir;
    private String registroData;
    private Integer sequencial;
    private String siafExportacao;
    private String siopWebEnvio;
    private UnidadeGestora unidadeGestora;
}
