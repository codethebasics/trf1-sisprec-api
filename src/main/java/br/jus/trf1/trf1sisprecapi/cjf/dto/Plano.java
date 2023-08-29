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
public class Plano {
    private Integer ano;
    private String descricao;
    private Fase fases;
    private Integer mes;
    private Boolean precatorio;
    private Boolean rps;
    private Boolean rpv;
    private Integer sequencial;
    private String tipo;
    private String tipoDescricao;
    private UnidadeGestora unidadeGestora;
}
