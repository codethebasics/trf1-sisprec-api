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
public class FaseTipo {
    private String codigo;
    private String descricao;
    private String observacao;
    private Integer ordem;
    private String origem;
    private Integer parcelaNumero;
    private Integer sequencial;
    private String utilizacaoFim;
}
