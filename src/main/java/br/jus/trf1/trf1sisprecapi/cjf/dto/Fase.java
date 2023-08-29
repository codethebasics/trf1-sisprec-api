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
public class Fase {
    private Boolean aberta;
    private String aberturaData;
    private Integer ano;
    private Integer anoExercicioOrcamentario;
    private String cancelamentoData;
    private String codSufixoProcessoSiaf;
    private Consolidacao[] consolidacaos;
    private String descricao;
    private String descricaoCurtaOuLonga;
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
