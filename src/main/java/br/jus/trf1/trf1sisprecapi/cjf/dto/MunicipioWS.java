package br.jus.trf1.trf1sisprecapi.cjf.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioWS {
    private Integer sequencial;
    private String codigo;
    private String descricao;
    private String uf;
}
