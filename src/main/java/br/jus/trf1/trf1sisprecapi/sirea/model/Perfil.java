package br.jus.trf1.trf1sisprecapi.sirea.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author bruno.carneiro (tr301605)
 */
@Data
@Entity
@Table(name="tb_perfil_usuario", schema="exec_celere")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfil")
    private Integer idPerfil;

    @Column(name="cd_perfil")
    private String codigoPerfil;

    @Column(name="ds_perfil")
    private String descricao;

    @Column(name = "il_interno")
    private Boolean interno;

    @Column(name = "ds_dominio_possivel")
    private String dominios;

    @Column(name="il_ativo")
    private Boolean ativo;
}
