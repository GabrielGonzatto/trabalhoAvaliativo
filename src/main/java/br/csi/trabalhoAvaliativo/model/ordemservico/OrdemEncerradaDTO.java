package br.csi.trabalhoAvaliativo.model.ordemservico;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.custos.Custos;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;

import java.util.Date;

public interface OrdemEncerradaDTO {

    Boolean getBoolean();
    OrdemEncerrada getDataSaida();
    Mecanico getMecanico();
    Custos getCustos();
    Cliente getCliente();
}
