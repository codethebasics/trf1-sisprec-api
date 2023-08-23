package br.jus.trf1.trf1sisprecapi.service.impl;

import br.jus.trf1.trf1sisprecapi.model.AuthenticationUser;
import br.jus.trf1.trf1sisprecapi.model.User;
import br.jus.trf1.trf1sisprecapi.service.SireaAuthenticationService;
import br.jus.trf1.trf1sisprecapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.Optional;

/**
 * Serviço de autenticação com a API do SIREA
 *
 * @author bruno.carneiro (tr301605)
 */
@Service
public class SireaAuthenticationServiceImpl implements SireaAuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public SireaAuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticationUser login(User user) throws CredentialException {
        try {
            User userFromDatabase = Optional.of(this.userService.findByUsername(user.getUsername()))
                    .orElseThrow(Exception::new);

            if (!this.passwordEncoder.matches(user.getPassword(), userFromDatabase.getPassword())) {
                throw new CredentialException("Credenciais inválidas");
            }
            return new AuthenticationUser(userFromDatabase);
        } catch (Exception e) {
            throw new CredentialException(e.getMessage());
        }
    }
}
