package br.csi.trabalhoAvaliativo.model.ordemservico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "ordemServico")
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
}
