package br.jus.trf1.trf1sisprecapi.sirea.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bruno.carneiro (tr301605)
 */
@Entity
@Data
@Table(schema = "exec_celere", name = "tb_tribunal")
@JsonIgnoreProperties(value = { "usuario", "dataHoraInclusao", "usuarios" })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tribunal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tribunal")
    private Long id;

    @Column(name = "nm_tribunal")
    private String nomeTribunal;

    @Column(name = "nr_cnpj")
    private String numCnpj;

    @ToString.Exclude
    @ManyToMany(mappedBy = "tribunais")
    private List<UsuarioCumprimentoSentenca> usuarios;

    @Column(name = "dh_inclusao")
    private LocalDateTime dataHoraInclusao;

    @Column(name = "il_ativo")
    private Boolean ativo;
}
