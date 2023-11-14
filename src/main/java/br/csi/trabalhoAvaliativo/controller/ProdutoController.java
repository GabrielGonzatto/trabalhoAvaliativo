package br.csi.trabalhoAvaliativo.controller;


import br.csi.trabalhoAvaliativo.model.produto.Produto;
import br.csi.trabalhoAvaliativo.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Produto produto(@PathVariable Long id){
        return this.service.listarProduto(id);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.ok(this.service.listarProdutos());
    }

    @PostMapping("/cadastrarProduto")
    @Transactional
    public ResponseEntity cadastrarProduto(@RequestBody @Valid Produto produto, UriComponentsBuilder uriBuilder){
        this.service.cadastrarProduto(produto);
        URI uri = uriBuilder.path("/produtoCusto/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Produto produto){
        this.service.atualizar(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
