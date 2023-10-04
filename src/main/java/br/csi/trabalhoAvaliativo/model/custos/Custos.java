package br.csi.trabalhoAvaliativo.model.custos;

import br.csi.trabalhoAvaliativo.model.produtoCusto.ProdutoCusto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "custos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Custos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NumberFormat(pattern = "#,###.##")
    private double valor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produtocusto", referencedColumnName = "id")
    private ProdutoCusto produtoCusto;
}