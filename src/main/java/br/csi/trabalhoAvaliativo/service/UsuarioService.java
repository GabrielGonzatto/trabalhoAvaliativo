package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import br.csi.trabalhoAvaliativo.model.usuario.DadosUsuario;
import br.csi.trabalhoAvaliativo.model.usuario.Usuario;
import br.csi.trabalhoAvaliativo.model.usuario.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Usuario usuario){
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        this.repository.save(usuario);
    }
    public List<DadosUsuario> findAllUsuarios() {
        return this.repository.findAll().stream().map(DadosUsuario::new).toList();
    }

    public Usuario findUsuario(Integer id) {
        return this.repository.findById(Math.toIntExact(id)).get();
    }

    public void deletar(Integer id) {
        this.repository.deleteById(Math.toIntExact(id));
    }

    public void atualizar(Usuario usuario) {
        Usuario u = this.repository.getReferenceById(Math.toIntExact(usuario.getIdusuario()));
        u.setLogin(usuario.getLogin());
        u.setSenha(usuario.getSenha());
        u.setPermissao(usuario.getPermissao());

    }
    public void cadastrarMecanico(Long idUsuario, Mecanico mecanico){

        Usuario usuario = this.repository.getReferenceById(Math.toIntExact(idUsuario));
    }
}
