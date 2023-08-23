package br.jus.trf1.trf1sisprecapi.service.impl;

import br.jus.trf1.trf1sisprecapi.model.AuthenticationUser;
import br.jus.trf1.trf1sisprecapi.model.User;
import br.jus.trf1.trf1sisprecapi.service.AuthenticationService;
import br.jus.trf1.trf1sisprecapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.CredentialException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
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
