package br.csi.trabalhoAvaliativo.model.mecanico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    Mecanico getById(Long idMecanico);

    Optional<Mecanico> findById(Long idMecanico);

    List<MecanicoDTO> findAllBy();

}
