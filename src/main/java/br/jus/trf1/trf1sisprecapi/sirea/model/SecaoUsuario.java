package br.jus.trf1.trf1sisprecapi.sirea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author bruno.carneiro (tr301605)
 */
@Data
@Entity
@Table(name="tb_secao_usuario", schema = "exec_celere")
public class SecaoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_secao_usuario")
    private Integer idSecaoUsuario;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private UsuarioCumprimentoSentenca usuario;

    @Column(name="id_secao", nullable=false)
    private Integer idSecao;

    @Column(name="nr_vara", nullable=false)
    private Integer numVara;

    @Column(name="dh_modificacao", nullable=false)
    private LocalDateTime dataModificacao;

    @Column(name="cd_usuario", nullable=false)
    private String loginUsuarioModificacao;

    @Column(name="il_ativo", nullable=false)
    private boolean ativo;

    @Column(name="il_tempo_indeterminado", nullable=true)
    private boolean tempoIndeterminado;

    @Column(name="dt_inicio_periodo", nullable=true)
    private Date dataInicial;

    @Column(name="dt_fim_periodo")
    private Date dataFinal;

}
