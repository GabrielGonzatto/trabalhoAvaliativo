package br.csi.trabalhoAvaliativo.model.custo;


import br.csi.trabalhoAvaliativo.model.ordem_servico.OrdemServico;
import br.csi.trabalhoAvaliativo.model.produto.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NumberFormat(pattern = "#,###.##")
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_ordemservico", referencedColumnName = "id")
    private OrdemServico ordemServico;
}