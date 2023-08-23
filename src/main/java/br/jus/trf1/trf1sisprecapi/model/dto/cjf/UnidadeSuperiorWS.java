package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeSuperiorWS {
    private Integer sequencial;
    private String codigo;
    private String nome;
    private String abreviatura;
    private String utilizacaoInicioData;
    private String utilizacaoFimData;
    private UnidadeSuperiorWS unidadeSuperior;
}
