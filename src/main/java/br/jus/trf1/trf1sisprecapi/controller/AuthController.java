package br.jus.trf1.trf1sisprecapi.controller;

import br.jus.trf1.trf1sisprecapi.model.AuthenticationUser;
import br.jus.trf1.trf1sisprecapi.model.User;
import br.jus.trf1.trf1sisprecapi.model.dto.CJFAuthenticationRequest;
import br.jus.trf1.trf1sisprecapi.model.dto.ResponseWrapper;
import br.jus.trf1.trf1sisprecapi.model.dto.SireaAuthRequest;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerUsuarioRetorno;
import br.jus.trf1.trf1sisprecapi.service.SireaAuthenticationService;
import br.jus.trf1.trf1sisprecapi.service.CJFAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Controller de autenticação
 *
 * @author brunocarneiro
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SireaAuthenticationService sireaAuthenticationService;
    private final CJFAuthenticationService cjfAuthenticationService;

    @Autowired
    public AuthController(SireaAuthenticationService sireaAuthenticationService, CJFAuthenticationService cjfAuthenticationService) {
        this.sireaAuthenticationService = sireaAuthenticationService;
        this.cjfAuthenticationService = cjfAuthenticationService;
    }

    /**
     * Realiza autenticação com banco de dados local
     */
    @PostMapping
    public ResponseEntity<String> authenticate(@RequestBody SireaAuthRequest sireaAuthRequest) {
        try {
            if (Objects.isNull(sireaAuthRequest)) {
                throw new Exception("As credenciais de autenticação do SIREA devem ser informadas");
            }

            AuthenticationUser authenticationUser = this.sireaAuthenticationService.login(User.builder()
                    .username(sireaAuthRequest.getCpfCnpj())
                    .password(sireaAuthRequest.getSenha())
                    .build());

            if (Objects.isNull(authenticationUser)) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Realiza autenticação no endpoint do CJF
     */
    @PostMapping(value = "/cjf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWrapper<SwaggerUsuarioRetorno>> authenticateOnCJF() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseWrapper.<SwaggerUsuarioRetorno>builder()
                        .retorno(this.cjfAuthenticationService.cjfAuthentication())
                        .build());
    }
}