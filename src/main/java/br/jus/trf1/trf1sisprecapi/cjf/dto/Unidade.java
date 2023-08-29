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
public class Unidade {
    private String abreviatura;
    private String codigo;
    private String nome;
    private Integer sequencial;
    private String siafiCodigo;
    private String siopCodigo;
    private Unidade unidadeSuperior;
    private String utilizacaoFimData;
    private String utilizaaoInicioData;
}
