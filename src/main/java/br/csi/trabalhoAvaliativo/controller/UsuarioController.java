package br.csi.trabalhoAvaliativo.controller;

import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import br.csi.trabalhoAvaliativo.model.usuario.DadosUsuario;
import br.csi.trabalhoAvaliativo.model.usuario.Usuario;
import br.csi.trabalhoAvaliativo.service.MecanicoService;
import br.csi.trabalhoAvaliativo.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    public UsuarioController(UsuarioService service, MecanicoService mecanicoService) {
        this.service = service;
        this.mecanicoService = mecanicoService;
    }

    private final UsuarioService service;
    private final MecanicoService mecanicoService;


    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder){
        this.service.cadastrar(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getIdusuario()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping("/listaUsuario")
    public List<DadosUsuario> listar(){
        return this.service.findAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity listaUsuario(@PathVariable Long id){
        this.service.findUsuario(Math.toIntExact(id));
        return ResponseEntity.accepted().body(this.service.findUsuario(Math.toIntExact(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        this.service.deletar(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Usuario usuario){
        this.service.atualizar(usuario);
        return ResponseEntity.ok(usuario);
    }
    @PutMapping("/{id}/cadastrarMecanico")
    public ResponseEntity cadastroMecanico(@PathVariable Long id, @RequestBody Mecanico mecanico, UriComponentsBuilder uriBuilder){

        this.mecanicoService.cadastrarMecanico(mecanico);
        Usuario usuario = this.service.findUsuario(Math.toIntExact(id));

        URI uri = uriBuilder.path("/usuario/{id}/sucesso").buildAndExpand(usuario.getIdusuario()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

}
