package br.csi.trabalhoAvaliativo.model.cliente;

import br.csi.trabalhoAvaliativo.model.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente extends Usuario {

    @NotBlank
    private String telefone;
}
