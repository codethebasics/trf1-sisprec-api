package br.jus.trf1.trf1sisprecapi.cjf.controller;

import br.jus.trf1.trf1sisprecapi.cjf.dto.SwaggerTabelaRetorno;
import br.jus.trf1.trf1sisprecapi.cjf.service.CJFAuthenticationService;
import br.jus.trf1.trf1sisprecapi.cjf.service.ConsultaTabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
 * @author bruno.carneiro (tr301605)
 */
@RestController
@RequestMapping("/tabela")
//@PreAuthorize("hasRole('ROLE_USER')")
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
    public SwaggerTabelaRetorno getTabelaItens(@PathVariable("tabela") String tabela) throws Exception {
        SwaggerTabelaRetorno tabelaItens = this.consultaTabelaService.getTabelaItens(tabela);
        return ResponseEntity
                .status(tabelaItens.getStatus())
                .body(tabelaItens)
                .getBody();
    }

    /**
     * Solicita à API do CJF o item de determinada tabela à partir do seu código
     *
     * @param tabela tabela a ser pesquisada
     * @param codigo código do registro a ser pesquisado
     * @return
     */
    @GetMapping("/itens/{tabela}/{codigo}")
    public SwaggerTabelaRetorno getTabelaItem(@PathVariable("tabela") String tabela, @PathVariable String codigo) throws Exception {
        SwaggerTabelaRetorno tabelaItens = this.consultaTabelaService.getTabelaItem(tabela, codigo);
        return ResponseEntity
                .status(tabelaItens.getStatus())
                .body(tabelaItens)
                .getBody();
    }
}
