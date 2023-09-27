package br.csi.trabalhoAvaliativo.model.mecanico;

import br.csi.trabalhoAvaliativo.model.ordemencerrada.OrdemEncerrada;
import br.csi.trabalhoAvaliativo.model.ordemservico.OrdemServico;
import br.csi.trabalhoAvaliativo.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;


@Entity
@Table(name = "mecanico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mecanico extends Usuario {

    @NotBlank
    @NumberFormat(pattern = "#,###.##")
    private double salario;

    @OneToMany(mappedBy = "mecanico")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;

    @OneToMany(mappedBy = "mecanico")
    @JsonIgnore
    private List<OrdemEncerrada> ordemEncerradas;
}
