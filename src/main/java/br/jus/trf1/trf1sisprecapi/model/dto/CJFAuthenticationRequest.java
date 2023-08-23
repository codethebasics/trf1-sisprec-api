package br.jus.trf1.trf1sisprecapi.model.dto;

import lombok.*;

/**
 * Objeto que representa uma requisição de autenticação no sistema do CJF
 *
 * @author bruno.carneiro
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CJFAuthenticationRequest {
    private String codigo;
    private String senha;

}
