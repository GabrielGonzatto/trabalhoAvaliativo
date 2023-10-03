package br.csi.trabalhoAvaliativo.controller;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.produtoCusto.ProdutoCusto;
import br.csi.trabalhoAvaliativo.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/cadastrarCliente")
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriBuilder) {

        this.service.cadastrarCliente(cliente);
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(this.service.listarClientes());
    }

    @GetMapping("/{id}")
    public Cliente cliente(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PutMapping("/editarCliente")
    @Transactional
    public ResponseEntity editarCliente(@RequestBody Cliente cliente){

        this.service.editarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCliente(@PathVariable Long id){

        this.service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}

