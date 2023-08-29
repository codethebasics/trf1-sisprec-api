package br.jus.trf1.trf1sisprecapi.sirea.service.impl;

import br.jus.trf1.trf1sisprecapi.system.model.AuthenticationUser;
import br.jus.trf1.trf1sisprecapi.system.model.User;
import br.jus.trf1.trf1sisprecapi.sirea.dto.SireaAuthRequest;
import br.jus.trf1.trf1sisprecapi.sirea.model.UsuarioCumprimentoSentenca;
import br.jus.trf1.trf1sisprecapi.sirea.repository.UsuarioCumprimentoSentencaRepository;
import br.jus.trf1.trf1sisprecapi.sirea.service.SireaAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.Objects;

/**
 * Serviço de autenticação com a API do SIREA
 *
 * @author bruno.carneiro (tr301605)
 */
@Service
public class SireaAuthenticationServiceImpl implements SireaAuthenticationService {

    private final UsuarioCumprimentoSentencaRepository repository;

    @Autowired
    public SireaAuthenticationServiceImpl(UsuarioCumprimentoSentencaRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuthenticationUser login(SireaAuthRequest sireaAuthRequest) throws CredentialException {
        try {
            UsuarioCumprimentoSentenca usuarioCumprimentoSentenca = this.repository.findByNumeroCpfCnpjAndSenha(
                    sireaAuthRequest.getCpfCnpj(),
                    sireaAuthRequest.getSenha());

            if (Objects.nonNull(usuarioCumprimentoSentenca)) {
                User user = User.builder()
                        .username(usuarioCumprimentoSentenca.getNumeroCpfCnpj())
                        .password(usuarioCumprimentoSentenca.getSenha())
                        .build();
                return new AuthenticationUser(user);
            }

            throw new RuntimeException("Credenciais inválidas");

        } catch (Exception e) {
            throw new CredentialException(e.getMessage());
        }
    }
}
