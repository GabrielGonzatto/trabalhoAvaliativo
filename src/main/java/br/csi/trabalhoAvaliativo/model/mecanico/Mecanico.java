package br.csi.trabalhoAvaliativo.model.mecanico;

import br.csi.trabalhoAvaliativo.model.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mecanico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mecanico extends Usuario {

    @NotBlank
    private double salario;

}
