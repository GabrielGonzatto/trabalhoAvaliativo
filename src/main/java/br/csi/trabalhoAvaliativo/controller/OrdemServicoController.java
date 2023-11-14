package br.csi.trabalhoAvaliativo.controller;


import br.csi.trabalhoAvaliativo.model.ordem_servico.OrdemServico;
import br.csi.trabalhoAvaliativo.model.ordem_servico.OrdemServicoDTO;
import br.csi.trabalhoAvaliativo.service.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {
    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public OrdemServico ordemServico(@PathVariable Long id){
        return this.service.listarOrdemServico(id);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarOrdensServicos(){
        return ResponseEntity.ok(this.service.listarOrdensServicos());
    }

    @PostMapping("/cadastrarOrdemServico")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity cadastrarOrdemServico(@RequestBody @Valid OrdemServico ordemServico, UriComponentsBuilder uriBuilder){
        this.service.cadastrarOrdemServico(ordemServico);
        URI uri = uriBuilder.path("/custo/{id}").buildAndExpand(ordemServico.getId()).toUri();

        return ResponseEntity.created(uri).body(ordemServico);
    }

    @PutMapping
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity atualizar(@RequestBody OrdemServico ordemServico){
        this.service.atualizar(ordemServico);
        return ResponseEntity.ok(ordemServico);
    }

    @PutMapping("/fecharOrdemServico")
    @Transactional
    public ResponseEntity fecharOrdemServico(@RequestBody OrdemServico ordemServico){
        this.service.fecharOrdemServico(ordemServico);
        return ResponseEntity.ok(ordemServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

