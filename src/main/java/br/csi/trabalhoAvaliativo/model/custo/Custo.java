package br.csi.trabalhoAvaliativo.model.custo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "custo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Custo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCusto;

    private String nomeCusto;

    @NumberFormat(pattern = "#,###.##")
    private double valor;
}
