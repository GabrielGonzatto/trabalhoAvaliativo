package br.csi.trabalhoAvaliativo.controller;

import br.csi.trabalhoAvaliativo.model.custos.Custos;
import br.csi.trabalhoAvaliativo.service.CustosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/custos")
public class CustosController {
    private final CustosService service;

    public CustosController(CustosService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Custos custo(@PathVariable Long id){
        return this.service.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<Custos>> listarCustos(){
        return ResponseEntity.ok(this.service.listarCustos());
    }

    @PostMapping("/cadastrarCustos")
    @Transactional
    public ResponseEntity cadastrarCusto(@RequestBody @Valid Custos custo, UriComponentsBuilder uriBuilder){
        this.service.cadastrarCusto(custo);
        URI uri = uriBuilder.path("/produtoCusto/{id}").buildAndExpand(custo.getId()).toUri();

        return ResponseEntity.created(uri).body(custo);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Custos custo){
        this.service.atualizar(custo);
        return ResponseEntity.ok(custo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
