package br.csi.trabalhoAvaliativo.controller;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import br.csi.trabalhoAvaliativo.service.ClienteService;
import br.csi.trabalhoAvaliativo.service.MecanicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {

    private final MecanicoService service;

    public MecanicoController(MecanicoService service) {
        this.service = service;
    }

    @PostMapping("/cadastrarMecanico")
    @Transactional
    public ResponseEntity cadastrarMecanico(@RequestBody @Valid Mecanico mecanico, UriComponentsBuilder uriBuilder) {

        this.service.cadastrarMecanico(mecanico);
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/mecanico/{id}").buildAndExpand(mecanico.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(mecanico);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<Mecanico>> listarMecanicos(){

        return ResponseEntity.ok(this.service.listarMecanicos());

    }

    @PutMapping("/editarMecanico")
    @Transactional
    public ResponseEntity editarMecanico(@RequestBody Mecanico mecanico){

        this.service.editarMecanico(mecanico);
        return ResponseEntity.ok(mecanico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMecanico(@PathVariable Long id){

        this.service.deletarMecanico(id);
        return ResponseEntity.noContent().build();
    }
}
