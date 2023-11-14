package br.csi.trabalhoAvaliativo.model.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public Produto getById(Long id);
    public Optional<Produto> findById(Long id);
}
