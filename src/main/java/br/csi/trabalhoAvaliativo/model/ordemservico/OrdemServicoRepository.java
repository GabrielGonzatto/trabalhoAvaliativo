package br.csi.trabalhoAvaliativo.model.ordemservico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    OrdemServico getById(Long id);
    Optional<OrdemServico> findById(Long id);

    List<OrdemServico> findAllBy();

    @Query(value = "SELECT * FROM ordem_servico where ativo = true", nativeQuery = true)
    List<OrdemServicoDTO> findAllActive();

    @Query(value = "SELECT * FROM ordem_servico where ativo = false", nativeQuery = true)
    List<OrdemEncerradaDTO> findAllInactive();
}
