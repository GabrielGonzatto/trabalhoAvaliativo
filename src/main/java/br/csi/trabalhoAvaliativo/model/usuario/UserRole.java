package br.csi.trabalhoAvaliativo.model.usuario;

public enum UserRole {
    CLIENT("client"),
    MECHANIC("mechanic");
    private String permissao;

    UserRole(String permissao){
        this.permissao = permissao;
    }

    public String getRole() {
        return permissao;
    }
}
