package br.jus.trf1.trf1sisprecapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO que representa uma requisição de autenticação no SIREA
 *
 * @author bruno.carneiro (tr301605)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SireaAuthRequest {
    private String cpfCnpj;
    private String senha;
}
