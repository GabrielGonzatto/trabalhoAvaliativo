package br.csi.trabalhoAvaliativo.model;

import br.csi.trabalhoAvaliativo.infra.security.TokenService;
import br.csi.trabalhoAvaliativo.model.usuario.DadosUsuario;
import br.csi.trabalhoAvaliativo.model.usuario.LoginResponseDTO;
import br.csi.trabalhoAvaliativo.model.usuario.Usuario;
import br.csi.trabalhoAvaliativo.model.usuario.UsuarioRepository;
import br.csi.trabalhoAvaliativo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    TokenService tokenService;
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DadosUsuario dados){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var auth = this.authenticationManager.authenticate(usuarioSenha);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder){
        this.usuarioService.cadastrar(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getIdusuario()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

}


