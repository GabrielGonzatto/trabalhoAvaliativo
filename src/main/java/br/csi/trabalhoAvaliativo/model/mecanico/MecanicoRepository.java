package br.csi.trabalhoAvaliativo.model.mecanico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    Mecanico getById(Long id);

    Optional<Mecanico> findById(Long id);

    List<MecanicoDTO> findAllBy();

}
