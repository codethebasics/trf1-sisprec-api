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
public class UnidadeGestora {
    private String abreviatura;
    private String codigo;
    private String codigoAtribuicao;
    private String codigoAtribuicaoSiafi;
    private String descricao;
    private Integer numTribunal;
    private Integer sequencial;
    private Unidade unidade;
    private UnidadeGestora unidadeGestora;
}
