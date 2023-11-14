package br.csi.trabalhoAvaliativo.model.ordem_servico;


public interface OrdemServicoDTO {
    Long getId();
    String getMarca();
    String getModelo();
    String getTipo();
    String getProblema();
    String getStatus();
    String getData_entrada();
    String getData_saida();
    double getTotal();
    boolean getAtivo();
}