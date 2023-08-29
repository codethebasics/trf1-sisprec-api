package br.jus.trf1.trf1sisprecapi.sirea.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author bruno.carneiro (tr301605)
 */
@Data
@Entity
@Table(schema = "exec_celere", name = "tb_usuario_exec")
@EqualsAndHashCode(exclude = { "perfisList", "secoesList", "tribunais" })
@JsonIgnoreProperties(value = { "dataModificacao", "senha" })
public class UsuarioCumprimentoSentenca {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_exec")
    private Long id;

    @JsonIgnoreProperties
    @Column(name = "id_usuario_pje")
    private Long idPje;

    @Column(name = "ds_usuario")
    private String usuario;

    @Column(name = "dh_modificacao")
    private Date dataModificacao;

    @Column(name = "il_ativo")
    private Boolean ativo;

    @Column(name = "nr_cpf_cnpj", length = 14, nullable = false)
    private String numeroCpfCnpj;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_hash_senha", length = 50, nullable = false)
    private String senha;

    @Column(name = "sg_tipo_usuario", length = 3)
    private String siglaTipoUsuario;

    @Column(name = "nm_matricula", length = 20)
    private String matricula;

    @JsonIgnoreProperties(value = { "usuario" }, allowSetters = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    @ToString.Exclude
    private Set<PerfilUsuarioAssociacao> perfisList;

    @JsonIgnoreProperties(value = { "usuario" }, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SecaoUsuario> secoesList;

    @Column(name = "cd_usuario")
    private String loginUsuarioUltimaModificacao;

    @Column(name = "ds_hash_sessao", length = 50)
    private String sessaoUsuario;

    @Column(name = "tp_especializacao")
    private Integer especializacao;

    @ManyToOne
    @JoinColumn(name = "id_orgao_executor")
    private Entidade orgaoExecutor;

    @Transient
    private Set<Integer> idsPerfisUsuario;

    @ManyToMany
    @JoinTable(
            schema = "exec_celere",
            name = "tb_usuario_tribunal",
            joinColumns = @JoinColumn(name = "id_usuario_exec"),
            inverseJoinColumns = @JoinColumn(name = "id_tribunal")
    )
    private List<Tribunal> tribunais;

    @Transient
    private boolean cadastroExterno;

}
