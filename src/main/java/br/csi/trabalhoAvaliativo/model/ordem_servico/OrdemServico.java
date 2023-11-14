package br.csi.trabalhoAvaliativo.model.ordem_servico;


import br.csi.trabalhoAvaliativo.model.custo.Custo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ordem_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String tipo;

    @NotBlank
    private String problema;

    private String status;

    private String data_entrada;

    private String data_saida;

    private Double total;

    private Boolean ativo;

    @OneToMany(mappedBy = "ordemServico")
    private List<Custo> custos;
}
