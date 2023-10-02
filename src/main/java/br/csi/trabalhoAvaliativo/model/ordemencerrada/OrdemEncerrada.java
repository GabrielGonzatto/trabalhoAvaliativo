package br.csi.trabalhoAvaliativo.model.ordemencerrada;

import br.csi.trabalhoAvaliativo.model.custo.Custo;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Entity
@Table(name = "ordemEncerrada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrdemEncerrada {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdemEncerrada;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataSaida;
    @NumberFormat(pattern = "#,###.##")
    private double total;

    @OneToOne
    @JoinColumn(name = "idCusto")
    private Custo custo;

    @ManyToOne
    @JoinColumn(name = "idMecanico")
    private Mecanico mecanico;
}
