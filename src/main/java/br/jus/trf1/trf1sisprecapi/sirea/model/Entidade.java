package br.jus.trf1.trf1sisprecapi.sirea.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bruno.carneiro (tr301605)
 */
@Entity
@Data
@Table(name = "tb_entidade", schema = "exec_celere")
public class Entidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidade")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_orgao_vinculado")
    @JsonIgnoreProperties(value = { "entidade" }, allowSetters = true)
    @ToString.Exclude
    private Entidade orgaoVinculado;

    @Column(name = "cd_entidade")
    private Integer codigo;

    @Column(name = "ds_entidade")
    private String descricao;

    @Column(name = "sg_ent_esfera")
    private Character siglaEsfera;

    @Column(name = "cd_unidade_orcamentaria")
    private Integer codigoUnidadeOrcamentaria;

    @Column(name = "cd_siafi")
    private Integer codigoSiafi;

    @Column(name = "cd_unidade_gestora")
    private Integer codigoUnidadeGestora;

    @Column(name = "cd_orgao_vinculado")
    private Integer codigoOrgaoVinculado;

    @Column(name = "il_prec")
    private Boolean precatorio;

    @Column(name = "il_prec_estadual")
    private Boolean precatorioEstadual;

    @Column(name = "nr_cnpj_entidade")
    private String cnpj;

    @Column(name = "id_ent_federativo")
    private Long idFederativo;

    @Column(name = "ds_logradouro")
    private String logradouro;

    @Column(name = "nr_cep")
    private Integer cep;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "nm_cidade_entidade")
    private String cidade;

    @Column(name = "dt_cadastro_entidade")
    private Date dataCadastro;

    @Column(name = "cd_usuario_cadastro")
    private String usuarioCadastro;

    @Column(name = "cd_usuario_cadastro_alteracao")
    private String usuarioAlteracao;

    @Column(name = "dt_cadastro_entidade_alteracao")
    private Date dataAlteracao;

    @Column(name = "uf_entidade")
    private String uf;

    @Column(name = "il_lotacao_servidor")
    private Boolean lotacaoServidor;

    @Column(name = "cd_usuario")
    private String usuario;

    @Column(name = "dh_modificacao")
    private Date dataModificacao;

    @Column(name = "il_ativo")
    private Boolean ativo;

    @Column(name = "nr_ordenacao")
    private Integer ordenacao;

}
