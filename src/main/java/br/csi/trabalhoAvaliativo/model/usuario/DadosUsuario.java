package br.csi.trabalhoAvaliativo.model.usuario;

public record DadosUsuario(String login, String senha){
    public DadosUsuario(Usuario usuario){
        this(usuario.getLogin(), usuario.getSenha());
    }

}
