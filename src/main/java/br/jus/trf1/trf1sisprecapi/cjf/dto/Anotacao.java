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
public class Anotacao {
    private Integer anotacaoPrincipalSequencial;
    private AnotacaoTipo anotacaoTipo;
    private String comentario;
    private String dataCancelamento;
    private String dataRegistro;
    private Fase fase;
    private Boolean positiva;
    private String recursoOriginalDescricao;
    private String recursoOriginalTipo;
    private String recursoPadronizadoDescricao;
    private String recursoPadronizadoTipo;
    private String recursoTipo;
    private Integer registroAnotadoSequencial;
    private Integer relevancia;
    private Integer sequencial;
    private String texto;
    private String textoCSV;
    private Usuario usuario;
}
