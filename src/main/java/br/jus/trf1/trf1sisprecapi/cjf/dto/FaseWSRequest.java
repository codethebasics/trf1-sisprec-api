package br.jus.trf1.trf1sisprecapi.cjf.dto;

import br.jus.trf1.trf1sisprecapi.cjf.enumeration.FaseEnum;
import br.jus.trf1.trf1sisprecapi.cjf.enumeration.PlanoTipoEnum;
import lombok.*;

/**
 * @author bruno.carneiro (tr301605)
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaseWSRequest {
    private FaseEnum fase;
    private String planoAnoMes;
    private PlanoTipoEnum planoTipo;
    private String unidadeGestoraCodigo;
}
