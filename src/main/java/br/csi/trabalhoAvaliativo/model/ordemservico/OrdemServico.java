package br.csi.trabalhoAvaliativo.model.ordemservico;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "ordem_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrdemServico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdem;
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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataEntrada;

    @ManyToOne
    @JoinColumn(name = "id_mecanico")
    private Mecanico mecanico;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
