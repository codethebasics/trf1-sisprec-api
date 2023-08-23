package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeJudicialWS {
    private Integer sequencial;
    private String codigo;
    private String descricao;
    private String utilizacaoInicioData;
    private String utilizacaoFimData;
    private String registroData;
    private MunicipioWS municipio;
}
