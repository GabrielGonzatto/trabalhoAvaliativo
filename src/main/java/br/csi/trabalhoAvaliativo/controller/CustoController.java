package br.csi.trabalhoAvaliativo.controller;

import br.csi.trabalhoAvaliativo.model.custo.Custo;
import br.csi.trabalhoAvaliativo.service.CustoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/custo")
public class CustoController {
    private final CustoService service;

    public CustoController(CustoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Custo custo(@PathVariable Long id){
        return this.service.listarCusto(id);
    }

    @GetMapping
    public ResponseEntity<List<Custo>> listarCustos(){
        return ResponseEntity.ok(this.service.listarCustos());
    }

    @PostMapping("/cadastrarCusto")
    @Transactional
    public ResponseEntity cadastrarCusto(@RequestBody @Valid Custo custo, UriComponentsBuilder uriBuilder){
        this.service.cadastrarCusto(custo);
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(custo.getId()).toUri();

        return ResponseEntity.created(uri).body(custo);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Custo custo){
        this.service.atualizar(custo);
        return ResponseEntity.ok(custo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
