package br.csi.trabalhoAvaliativo.model.mecanico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {

    public Mecanico getById(Long id);

    public Optional<Mecanico> findById(Long id);

    public List<Mecanico> findUsuariosById(@Param("id") Long id);
}
