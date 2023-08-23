package br.jus.trf1.trf1sisprecapi.service;


import br.jus.trf1.trf1sisprecapi.model.AuthenticationUser;
import br.jus.trf1.trf1sisprecapi.model.User;

import javax.security.auth.login.CredentialException;

public interface AuthenticationService {

    AuthenticationUser login(User user) throws CredentialException;

}
