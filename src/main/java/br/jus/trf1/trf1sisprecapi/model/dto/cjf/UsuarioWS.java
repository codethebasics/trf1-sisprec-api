package br.jus.trf1.trf1sisprecapi.model.dto.cjf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa um objeto de requisição contendo as credenciais de acesso
 * ao endpoint de autenticação do CJF
 *
 * @author bruno.carneiro
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioWS {
    private String codigo;
    private String senha;
}
