package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndiceWS {
    private Integer sequencial;
    private IndiceTipoWS indiceTipo;
    private String registro;
    private String validadeInicio;
    private String validadeFim;
    private Integer ano;
    private Integer mes;
    private Integer valor;
}
