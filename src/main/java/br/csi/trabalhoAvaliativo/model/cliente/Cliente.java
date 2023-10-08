package br.csi.trabalhoAvaliativo.model.cliente;


import br.csi.trabalhoAvaliativo.model.ordemservico.OrdemServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    @NotBlank
    private String nome;
    @Size(max = 14, message = "Cpf com mais de 14 caracteres")
    private String cpf;
    @NotBlank
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;


}