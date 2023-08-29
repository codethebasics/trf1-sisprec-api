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
public class UnidadeGestoraUsuarioPerfil {
    private String codPerfil;
    private String fimData;
    private String inicioData;
    private Perfil perfil;
    private Integer seqPerfil;
    private Integer seqUnidadeGestora;
    private Integer seqUsuario;
    private Integer sequencial;
    private UnidadeGestora unidadeGestora;
}
