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
public class AnotacaoTipo {
    private String descricao;
    private Integer sequencial;
    private Integer sequencialSuperior;
    private String utilizacaoFim;
}
