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
public class UnidadeJudicial {
    private Integer acaoOriginariaUnidadeJudicialSequencial;
    private String codigo;
    private String descricao;
    private String entrada;
    private Municipio municipio;
    private String registroData;
    private String saida;
    private String sequencial;
    private UnidadeTipo unidadeTipo;
    private String utilizacaoFimData;
    private String utilizacaoInicioData;
}
