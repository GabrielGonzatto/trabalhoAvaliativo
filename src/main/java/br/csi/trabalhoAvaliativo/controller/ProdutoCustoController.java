package br.csi.trabalhoAvaliativo.controller;


import br.csi.trabalhoAvaliativo.model.produtoCusto.ProdutoCusto;
import br.csi.trabalhoAvaliativo.service.ProdutoCustoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtoCusto")
public class ProdutoCustoController {
    private final ProdutoCustoService service;

    public ProdutoCustoController(ProdutoCustoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ProdutoCusto produtoCusto(@PathVariable Long id){
        return this.service.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoCusto>> listarProdutosCustos(){
        return ResponseEntity.ok(this.service.listarProdutosCustos());
    }

    @PostMapping("/cadastrarProdutoCusto")
    @Transactional
    public ResponseEntity cadastrarProdutoCusto(@RequestBody @Valid ProdutoCusto produtoCusto, UriComponentsBuilder uriBuilder){
        this.service.cadastrarProdutoCusto(produtoCusto);
        URI uri = uriBuilder.path("/produtoCusto/{id}").buildAndExpand(produtoCusto.getId()).toUri();

        return ResponseEntity.created(uri).body(produtoCusto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody ProdutoCusto produtoCusto){
        this.service.atualizar(produtoCusto);
        return ResponseEntity.ok(produtoCusto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
