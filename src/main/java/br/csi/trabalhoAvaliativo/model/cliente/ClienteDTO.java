package br.csi.trabalhoAvaliativo.model.cliente;

public interface ClienteDTO {

    Long getId();
    String getNome();
    String getCpf();
    String getLogin();
    String getSenha();
    String getPermissao();
    String getTelefone();
}
