package br.jus.trf1.trf1sisprecapi.sirea.service;


import br.jus.trf1.trf1sisprecapi.system.model.AuthenticationUser;
import br.jus.trf1.trf1sisprecapi.sirea.dto.SireaAuthRequest;

import javax.security.auth.login.CredentialException;

public interface SireaAuthenticationService {

    AuthenticationUser login(SireaAuthRequest sireaAuthRequest) throws CredentialException;

}
