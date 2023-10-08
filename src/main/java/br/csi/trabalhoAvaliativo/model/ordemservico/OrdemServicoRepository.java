package br.csi.trabalhoAvaliativo.model.ordemservico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    OrdemServico getById(Long id);
    Optional<OrdemServico> findById(Long id);

    //List<OrdemServicoDTO> findAllBy();
    List<OrdemServico> findAllBy();

    @Query(value = "SELECT id, marca, modelo, tipo, problema, status, data_entrada, id_cliente, id_mecanico FROM ordem_servico where ativo is TRUE;", nativeQuery = true)
    List<OrdemServicoDTO> findAllActive();

    @Query(value = "SELECT o.id, o.marca, o.modelo, o.tipo, o.problema, o.status, o.data_entrada, o.data_saida, o.total, o.id_cliente, o.id_mecanico, c.nome, m.nome FROM " +
            "ordem_servico o INNER JOIN cliente c on o.id_cliente =  c.id_cliente " +
            "INNER JOIN mecanico m on o.id_mecanico = m.id_mecanico " +
            "where ativo is false;", nativeQuery = true)
    List<OrdemEncerradaDTO> findAllInactive();
}
