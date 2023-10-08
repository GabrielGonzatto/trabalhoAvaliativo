package br.csi.trabalhoAvaliativo.model.usuario;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Entity(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idusuario;
    @Email(message = "Email Invalido")
    private String login;
    @NotBlank
    private String senha;
    private UserRole permissao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_mecanico")
    private Mecanico mecanico;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.permissao == UserRole.MECHANIC) return List.of(new SimpleGrantedAuthority("ROLE_MECHANIC"), new SimpleGrantedAuthority("ROLE_MECHANIC"));
        else return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return senha;
    }
    @JsonIgnore
    @Override
    public String getUsername() {

        return login;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
