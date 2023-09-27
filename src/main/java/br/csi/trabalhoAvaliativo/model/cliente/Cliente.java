package br.csi.trabalhoAvaliativo.model.cliente;

import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
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

import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente extends Usuario {

    @NotBlank
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;
}
