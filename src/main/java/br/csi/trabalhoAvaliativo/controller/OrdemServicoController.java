package br.csi.trabalhoAvaliativo.controller;


import br.csi.trabalhoAvaliativo.model.ordemservico.OrdemEncerradaDTO;
import br.csi.trabalhoAvaliativo.model.ordemservico.OrdemServico;
import br.csi.trabalhoAvaliativo.model.ordemservico.OrdemServicoDTO;
import br.csi.trabalhoAvaliativo.service.OrdemServicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrarOrdemServico")
    @Transactional
    public ResponseEntity cadastrarOrdemServico(@RequestBody @Valid OrdemServico ordemServico, UriComponentsBuilder uriBuilder){

        this.service.cadastrarOrdem(ordemServico);
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/ordemServico/{idOrdem}").buildAndExpand(ordemServico.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(ordemServico);

    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<OrdemServico>> listarOrdens(){
        return ResponseEntity.ok(this.service.listarOrdens());
    }

    @GetMapping("/ordemAtiva")
    @Transactional
    public ResponseEntity<List<OrdemServicoDTO>> listarOrdensAtivas(){return ResponseEntity.ok(this.service.listarOrdensAtivas());}

    @GetMapping("/ordemInativa")
    @Transactional
    public ResponseEntity<List<OrdemEncerradaDTO>> listarOrdensInativas(){return ResponseEntity.ok(this.service.listarOrdensInativas());}



    @PutMapping
    @Transactional
    public ResponseEntity editarOrdemServico(@RequestBody OrdemServico ordemServico){

        this.service.atualizar(ordemServico);

        return ResponseEntity.ok(ordemServico);
    }
    @GetMapping("/{id}")
    @Transactional
    public OrdemServico findById(@PathVariable Long id){
        return this.service.findById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarOrdemServico(@PathVariable Long id){

        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/encerrarOrdem")
    @Transactional
    public ResponseEntity encerrarOrdemServico(@RequestBody OrdemServico ordemServico){
        this.service.encerrarOrdem(ordemServico);
        return ResponseEntity.ok(ordemServico);
    }


}
