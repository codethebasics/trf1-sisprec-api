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
public class ContaBancaria {
    private Integer agenciaNumero;
    private Integer bancoNumero;
    private String contaCodigo;
    private Integer sequencial;
}
