package br.jus.trf1.trf1sisprecapi.cjf.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssuntoWS {

    private String codigo;
    private String codigoCnj;
    private String dataAtualizacao;
    private String descricao;
    private String descricaoCnj;
    private Integer sequencia;
}
