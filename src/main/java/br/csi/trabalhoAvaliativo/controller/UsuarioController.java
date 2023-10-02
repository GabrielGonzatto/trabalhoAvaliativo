package br.csi.trabalhoAvaliativo.controller;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import br.csi.trabalhoAvaliativo.service.ClienteService;
import br.csi.trabalhoAvaliativo.service.MecanicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private final ClienteService service;
    private final MecanicoService service2;

    public UsuarioController(ClienteService service, MecanicoService service2) {
        this.service = service;
        this.service2 = service2;
    }


    @PostMapping("/cadastrarCliente")
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid Cliente cliente, UriComponentsBuilder uriBuilder) {

        this.service.cadastrarCliente(cliente);
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(cliente.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(cliente);
    }
    @PostMapping("/cadastrarMecanico")
    @Transactional
    public ResponseEntity cadastrarMecanico(@RequestBody @Valid Mecanico mecanico, UriComponentsBuilder uriComponentsBuilder){
        this.service2.cadastroMecanico(mecanico);
        URI uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(mecanico.getId()).toUri();
        return ResponseEntity.created(uri).body(mecanico);
    }
}
