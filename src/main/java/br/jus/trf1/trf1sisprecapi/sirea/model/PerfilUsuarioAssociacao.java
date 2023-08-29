package br.jus.trf1.trf1sisprecapi.sirea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author bruno.carneiro (tr301605)
 */
@Data
@Entity
@Table(name = "tb_perfil_usuario_assoc", schema = "exec_celere")
public class PerfilUsuarioAssociacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil_usuario_assoc")
    private Integer idPerfilUsuarioAssoc;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioCumprimentoSentenca usuario;

    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false)
    private Perfil perfil;

    @Column(name = "dh_modificacao", nullable = false)
    private LocalDateTime dataModificacao;

    @Column(name = "cd_usuario", nullable = false)
    private String loginUsuarioModificacao;

    @Column(name = "il_ativo", nullable = false)
    private boolean ativo;
}
