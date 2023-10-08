package br.csi.trabalhoAvaliativo.model.produtoCusto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoCustoRepository extends JpaRepository<ProdutoCusto, Long> {
    public ProdutoCusto getById(Long id);
    public Optional<ProdutoCusto> findById(Long id);

    /*@Query(value = "SELECT pc.idProdutoCusto as id, pc.nomeCusto as nome " +
            "FROM produtoCusto pc WHERE a.idPodutoCusto =:id", nativeQuery = true)
    List<ProdutoCustoDTO> findProdutoCustoByProjeto(@Param("id") int id);*/
}
