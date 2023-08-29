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
public class PessoaWS {
    private String codigoCpfCnpj;
    private String falecimentoData;
    private String nacimentoData;
    private String nome;
    private String nomeSocial;
    private String principal;
    private String razaoSocial;
    private Integer sequencial;
}
