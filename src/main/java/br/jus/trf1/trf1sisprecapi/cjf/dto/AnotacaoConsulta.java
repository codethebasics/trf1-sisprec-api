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
public class AnotacaoConsulta {
    private Boolean anotacaoAtivo;
    private Boolean anotacaoPositivo;
    private String anotacaoRegistroDataFinal;
    private String anotacaoRegistroDataInicial;
    private Integer anotacaoRelevancia;
    private Integer[] anotacaoSuperiorSequencial;
    private Integer[] anotacaoTipoSequencial;
    private Integer faseAno;
    private Integer faseAnoExercicioOrcamentario;
    private Integer faseMes;
    private Integer faseSequencial;
    private String[] faseTipoOrigens;
    private String ordenacaoCampo;
    private String[] ordenacaoCampos;
    private String ordenacaoTipo;
    private Integer pagina;
    private Integer planoAnoReferencia;
    private Integer planoMesReferencia;
    private Boolean planoPrecatorio;
    private Integer planoSequencial;
    private String[] planosTipos;
    private String recursoOriginalTipo;
    private String recursoPadronizadoTipo;
    private String recursoRemotoTipo;
    private Integer registrosPorPagina;
    private Integer sequencial;
    private Integer tipoFaseSequencial;
    private Integer unidadeGestoraSequencial;
    private Integer[] unidadesGestorasSequenciais;
    private Integer usuarioSequencial;
    private String[] usuariosCPFs;
}
