package br.csi.trabalhoAvaliativo.model.ordemservico;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;

import java.util.Date;

public interface OrdemServicoDTO {
    Long getId();
    String getMarca();
    String getModelo();
    String getTipo();
    String getProblema();
    String getStatus();
    Date getDataEntrada();
    Mecanico getMecanico();
    Cliente getCliente();
}
