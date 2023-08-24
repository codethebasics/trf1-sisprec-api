package br.jus.trf1.trf1sisprecapi.controller;

import br.jus.trf1.trf1sisprecapi.model.dto.ResponseWrapper;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerTabelaRetorno;
import br.jus.trf1.trf1sisprecapi.model.dto.cjf.SwaggerUsuarioRetorno;
import br.jus.trf1.trf1sisprecapi.service.ConsultaTabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsável pela interação com a API de consulta de tabelas do CJF
 *
 * Para consultar o Swagger do CJF, favor acessar
 * <a href="https://www4.cjf.jus.br/precatorios_api/swagger/swagger-ui.html#">https://www4.cjf.jus.br/precatorios_api/swagger/swagger-ui.html#</a>
 *
 * O serviço não requer autenticação para ser utilizado
 *
 * @author bruno.carneiro (tr301605)
 */
@RestController
@RequestMapping("/tabela")
@PreAuthorize("hasRole('ROLE_USER')")
public class ConsultaTabelaController {

    private final ConsultaTabelaService consultaTabelaService;

    @Autowired
    public ConsultaTabelaController(ConsultaTabelaService consultaTabelaService) {
        this.consultaTabelaService = consultaTabelaService;
    }

    /**
     * Solicita à API do CJF todos os itens de determinada tabela
     *
     * @param tabela tabela a ser pesquisada
     * @return
     */
    @GetMapping("/itens/{tabela}")
    public ResponseEntity<ResponseWrapper<SwaggerTabelaRetorno>> getTabelaItens(@PathVariable("tabela") String tabela) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseWrapper.<SwaggerTabelaRetorno>builder()
                        .retorno(this.consultaTabelaService.getTabelaItens(tabela))
                        .build());
    }

    /**
     * Solicita à API do CJF o item de determinada tabela à partir do seu código
     *
     * @param tabela tabela a ser pesquisada
     * @param codigo código do registro a ser pesquisado
     * @return
     */
    @GetMapping("/itens/{tabela}/{codigo}")
    public ResponseEntity<ResponseWrapper<SwaggerTabelaRetorno>> getTabelaItem(@PathVariable("tabela") String tabela, @PathVariable Long codigo) {
        return null;
    }
}
