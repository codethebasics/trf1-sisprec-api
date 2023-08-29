package br.jus.trf1.trf1sisprecapi.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Representa as permissões de um usuário
 *
 * @author bruno.carneiro
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "authority")
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private List<User> users;

}
