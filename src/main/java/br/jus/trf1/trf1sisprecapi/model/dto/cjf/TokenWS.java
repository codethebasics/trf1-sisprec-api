package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import lombok.*;

/**
 * Representa uma token de acesso aos serviços do CJF
 *
 * @author bruno.carneiro
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenWS {
    private String token;

}
