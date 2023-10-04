package br.csi.trabalhoAvaliativo.model.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente getById(Long id);
    Optional<Cliente> findById(Long id);
    List<ClienteDTO> findAllBy();

}
