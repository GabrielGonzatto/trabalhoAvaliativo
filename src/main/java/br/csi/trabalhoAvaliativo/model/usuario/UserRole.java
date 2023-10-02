package br.csi.trabalhoAvaliativo.model.usuario;

public enum UserRole {

    ADMIN("admin"),
    USER("user");
    private String permissao;

    UserRole(String permissao){
        this.permissao = permissao;
    }

    public String getRole() {
        return permissao;
    }
}
