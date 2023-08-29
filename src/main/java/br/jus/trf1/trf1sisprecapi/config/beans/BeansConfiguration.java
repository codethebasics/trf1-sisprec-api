package br.jus.trf1.trf1sisprecapi.config.beans;

import br.jus.trf1.trf1sisprecapi.config.security.RestTemplateHeaderAuthenticationInterceptor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuração dos beans da aplicação
 *
 * @author bruno.carneiro
 */
@Configuration
public class BeansConfiguration {

    public static String jwtToken;

    /**
     * Bean de mapeamento de entidades -> JSON
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper;
    }

    /**
     * Bean de conversão
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    /**
     * Bean que armazena o RestTemplate utilizado para o consumo das
     * APIs do CJF
     */
    @Bean
    public RestTemplate restTemplate() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }

        interceptors.add(new RestTemplateHeaderAuthenticationInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
