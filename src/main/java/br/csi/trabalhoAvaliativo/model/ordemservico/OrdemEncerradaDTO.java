package br.csi.trabalhoAvaliativo.model.ordemservico;


import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.custos.Custos;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;

public interface OrdemEncerradaDTO {

    Boolean getBoolean();
    OrdemEncerrada getData();
    Mecanico getMecanico();
    Custos getCustos();
    Cliente getCliente();
}
