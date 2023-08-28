package br.jus.trf1.trf1sisprecapi.config.security;

import br.jus.trf1.trf1sisprecapi.config.beans.BeansConfiguration;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Classe responsável por adicionar dinamicamente a token JWT
 * de autenticação para consumir os endpoints do CJF
 *
 * @author bruno.carneiro (tr301605)
 */
public class RestTemplateHeaderAuthenticationInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if (Strings.isNotBlank(BeansConfiguration.jwtToken)) {
            request.getHeaders().add("Authorization", "Bearer " + BeansConfiguration.jwtToken);
        }
        return execution.execute(request, body);
    }
}
