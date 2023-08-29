package br.jus.trf1.trf1sisprecapi.sirea.repository;

import br.jus.trf1.trf1sisprecapi.sirea.model.UsuarioCumprimentoSentenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bruno.carneiro (tr301605)
 */
@Repository
public interface UsuarioCumprimentoSentencaRepository extends JpaRepository<UsuarioCumprimentoSentenca, Long> {

    /**
     * Busca usuário pelo login e senha
     */
    UsuarioCumprimentoSentenca findByNumeroCpfCnpjAndSenha(String numeroCpfCnpj, String senhaMD5);

}
