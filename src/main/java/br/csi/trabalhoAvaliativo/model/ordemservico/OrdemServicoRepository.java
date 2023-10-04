package br.csi.trabalhoAvaliativo.model.ordemservico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    OrdemServico getById(Long id);
    Optional<OrdemServico> findById(Long id);

    //List<OrdemServicoDTO> findAllBy();
    List<OrdemServico> findAllBy();
}
