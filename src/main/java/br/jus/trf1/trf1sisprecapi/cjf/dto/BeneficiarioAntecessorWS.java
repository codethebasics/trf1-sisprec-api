package br.jus.trf1.trf1sisprecapi.cjf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author bruno.carneiro (tr301605)
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioAntecessorWS {
    private String originario;
    private PessoaWS pessoa;
    private String registroData;
    @JsonProperty("seq_beneficiario")
    private Integer seqBeneficiario;
    private Integer sequencial;
    private String sucessaoData;
}
