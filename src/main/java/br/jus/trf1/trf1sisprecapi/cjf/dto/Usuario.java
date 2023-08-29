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
public class Usuario {
    private String chave;
    @JsonProperty("cod_cpf")
    private String codCpf;
    private String gestorTecnico;
    @JsonProperty("ind_ativo")
    private String indAtivo;
    @JsonProperty("nome_usuario")
    private String nomeUsuario;
    @JsonProperty("num_mat_servidor")
    private String numMatServidor;
    @JsonProperty("num_telefone")
    private String numTelefone;
    @JsonProperty("sen_usuario")
    private String senUsuario;
    @JsonProperty("seq_usuario")
    private Integer seqUsuario;
    @JsonProperty("txt_email")
    private String txtEmail;
    private UnidadeGestoraUsuarioPerfil[] unidadesGestorasPerfis;
}
