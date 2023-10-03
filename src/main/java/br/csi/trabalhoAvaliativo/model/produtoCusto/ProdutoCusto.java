package br.csi.trabalhoAvaliativo.model.produtoCusto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto_custo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProdutoCusto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;



}
