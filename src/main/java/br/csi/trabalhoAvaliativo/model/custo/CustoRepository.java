package br.csi.trabalhoAvaliativo.model.custo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustoRepository extends JpaRepository<Custo, Long> {
    public Custo getById(Long id);

    public Optional<Custo> findById(Long id);
}
