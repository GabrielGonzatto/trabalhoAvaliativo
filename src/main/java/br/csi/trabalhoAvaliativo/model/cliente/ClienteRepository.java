package br.csi.trabalhoAvaliativo.model.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente getById(Long id);
    public Optional<Cliente> findById(Long id);
    List<ClienteDTO> findUsuariosByid(@Param("id") Long id);

}
