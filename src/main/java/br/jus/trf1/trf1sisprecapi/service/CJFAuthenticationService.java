package br.jus.trf1.trf1sisprecapi.service;

import br.jus.trf1.trf1sisprecapi.model.dto.CJFAuthenticationRequest;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerUsuarioRetorno;

public interface CJFAuthenticationService {

    SwaggerUsuarioRetorno cjfAuthentication();
}
