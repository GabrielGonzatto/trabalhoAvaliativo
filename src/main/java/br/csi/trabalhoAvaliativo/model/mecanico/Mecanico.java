package br.csi.trabalhoAvaliativo.model.mecanico;

import br.csi.trabalhoAvaliativo.model.ordemencerrada.OrdemEncerrada;
import br.csi.trabalhoAvaliativo.model.ordemservico.OrdemServico;
import br.csi.trabalhoAvaliativo.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "mecanico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mecanico extends Usuario {

    @NotNull
    private BigDecimal salario;

    @OneToMany(mappedBy = "mecanico")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;

    /*@OneToMany(mappedBy = "mecanico")
    private List<OrdemEncerrada> ordemEncerradas;*/
}
