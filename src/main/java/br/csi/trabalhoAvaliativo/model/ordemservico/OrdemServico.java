package br.csi.trabalhoAvaliativo.model.ordemservico;


import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ordem_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrdemServico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String tipo;
    @NotBlank
    private String problema;
    @NotBlank
    private String status;
    @Column(name = "data_entrada")
    private Date dataEntrada;

    private Boolean ativo;
    @Embedded
    private OrdemEncerrada ordemEncerrada;


    @ManyToOne
    @JoinColumn(name = "id_mecanico")
    private Mecanico mecanico;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
