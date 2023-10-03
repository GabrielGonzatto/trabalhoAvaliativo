package br.csi.trabalhoAvaliativo.model.ordemservico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    public OrdemServico getById(Long id);
    public Optional<OrdemServico> findById(Long id);

}
