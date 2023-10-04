package br.csi.trabalhoAvaliativo.model.custos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustosRepository extends JpaRepository<Custos, Long> {

    public Custos getById(Long id);

    public Optional<Custos> findById(Long id);
}
