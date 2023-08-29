package br.jus.trf1.trf1sisprecapi.cjf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioSucessaoTipoWS {
    @JsonProperty("CESSIONARIO")
    private String cessionario;
    @JsonProperty("SUCESSOR")
    private String sucessor;
    @JsonProperty("TERCEIRO")
    private String terceiro;
    @JsonProperty("HERDEIRO")
    private String herdeiro;
}
