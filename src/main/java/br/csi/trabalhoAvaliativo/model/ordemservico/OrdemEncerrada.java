package br.csi.trabalhoAvaliativo.model.ordemservico;

import br.csi.trabalhoAvaliativo.model.custos.Custos;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Embeddable
@Table(name = "ordem_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrdemEncerrada {

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date data_saida;
    @NumberFormat(pattern = "#,###.##")
    private double total;

}
