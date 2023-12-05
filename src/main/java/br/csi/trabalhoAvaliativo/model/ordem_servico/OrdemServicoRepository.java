package br.csi.trabalhoAvaliativo.model.ordem_servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    public OrdemServico getById(Long id);

    public Optional<OrdemServico> findById(Long id);

    @Query(value = "select * from ordem_servico where ordem_servico.ativo = true ;", nativeQuery = true)
    List<OrdemServico> listarOrdensServicosAtivas();

    @Query(value = "select * from ordem_servico where ordem_servico.ativo = false ;", nativeQuery = true)
    List<OrdemServico> listarOrdensServicosDesativadas();
}
