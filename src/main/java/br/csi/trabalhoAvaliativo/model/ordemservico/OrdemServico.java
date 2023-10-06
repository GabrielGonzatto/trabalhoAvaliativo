package br.csi.trabalhoAvaliativo.model.ordemservico;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.custos.Custos;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "ordemServico")
    private List<Custos> custos;
    public void calcularTotal() {
        this.ordemEncerrada.setTotal(custos.stream().mapToDouble(Custos::getValor).sum());
    }
    @ManyToOne
    @JoinColumn(name = "id_mecanico")
    private Mecanico mecanico;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
