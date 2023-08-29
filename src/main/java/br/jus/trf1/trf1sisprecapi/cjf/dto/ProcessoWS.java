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
public class ProcessoWS {
    private AcaoOriginariaWS acaoOriginaria;
    private PessoaWS[] advogados;
    private AssuntoWS assunto;
    private String autuacaoData;
    private String autuacaoOriginariaData;
    private BeneficiarioWS[] beneficiarios;
    private Integer beneficiariosConta;
    private Float beneficiariosSomaValores;
    private Boolean bloqueio;
    private String cancelamentoData;
    private String causaTipo;
    private ContaBancaria contaBancaria;
    private String dataBaseUltimoCalculo;
    private DespesaClassificacaoWS despesaClassificacaoWS;
    private String exclusaoData;
    private FaseWS fase;
    @JsonProperty("gru_numero")
    private String gruNumero;
    private String inclusaoData;
    private Integer mesPrevisaoPagamento;
    private MovimentoTipoWS movimentoTipo;
    private String nomeIndiceAdotadoAtualizacaoMonetaria;
    private String observacao;
    private Boolean paragrafo20Artigo1100ConstituicaoFederal;
    private String processoAjuizamento;
    private String processoNumero;
    private ProcessoAnterior[] processosAnteriores;
    private String registroData;
    private Boolean reinclusaoLei13463;
    private PessoaWS[] requerentes;
    private SentencaTipoWS sentencaTipo;
    private String transitoJulgadoData;
    private Boolean tributario;
    private UnidadeWS unidadeCadastradora;
    private UnidadeWS unidadeExecutada;
    private String unidadeJudicialTipo;
    private Float valorOriginalUltimoCalculo;
    private ValorPrecatorioWS[] valores;

}
