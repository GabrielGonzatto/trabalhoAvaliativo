package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.custo.Custo;
import br.csi.trabalhoAvaliativo.model.custo.CustoRepository;
import br.csi.trabalhoAvaliativo.model.produto.Produto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustoService {
    private CustoRepository repository;

    @Autowired
    private EntityManager entityManager;

    public CustoService(CustoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarCusto(Custo custo) {
        Produto produtoExistente = entityManager.find(Produto.class, custo.getProduto().getId());

        if(produtoExistente != null){
            custo.setProduto(produtoExistente);
            this.repository.save(custo);
        } else {
            this.repository.save(custo);
        }
    }

    public List<Custo> listarCustos(){
        return this.repository.findAll();
    }

    public Custo listarCusto(Long id){
        return this.repository.findById(id).get();
    }

    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public void atualizar(Custo custo){
        Custo c = this.repository.getReferenceById(custo.getId());
        c.setValor(custo.getValor());
    }
}