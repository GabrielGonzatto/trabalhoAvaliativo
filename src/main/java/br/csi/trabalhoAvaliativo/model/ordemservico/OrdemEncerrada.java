package br.csi.trabalhoAvaliativo.model.ordemservico;

import br.csi.trabalhoAvaliativo.model.custos.Custos;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;
import java.util.List;

@Embeddable
@Table(name = "ordem_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrdemEncerrada {

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_saida")
    private Date dataSaida;
    @NumberFormat(pattern = "#,###.##")
    private Double total;
    @OneToMany(mappedBy = "ordemServico")
    private List<Custos> custos;
    public void calcularTotal(List<Custos> custos) {
        this.total = custos.stream().mapToDouble(Custos::getValor).sum();
    }
}
