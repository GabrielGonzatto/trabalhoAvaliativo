package br.csi.trabalhoAvaliativo.model.mecanico;


import br.csi.trabalhoAvaliativo.model.ordem_servico.OrdemServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "mecanico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mecanico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mecanico")
    private Long idMecanico;
    @NotNull
    private BigDecimal salario;

    @OneToMany(mappedBy = "mecanico")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;


}