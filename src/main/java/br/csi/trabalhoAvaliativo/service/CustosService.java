package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.custos.Custos;
import br.csi.trabalhoAvaliativo.model.custos.CustosRepository;
import br.csi.trabalhoAvaliativo.model.produtoCusto.ProdutoCusto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustosService {
    private CustosRepository repository;

    @Autowired
    private EntityManager entityManager;

    public CustosService(CustosRepository repository) {
        this.repository = repository;
    }

    public void cadastrarCusto(Custos custo){
        ProdutoCusto produtoCustoExistente = entityManager.find(ProdutoCusto.class, custo.getProdutoCusto().getId());

        if(produtoCustoExistente != null){
            custo.setProdutoCusto(produtoCustoExistente);
            this.repository.save(custo);
        } else {
            this.repository.save(custo);
        }

        this.repository.save(custo);
    }

    public List<Custos> listarCustos(){
        return this.repository.findAll();
    }

    public Custos findById(Long id){
        return this.repository.findById(id).get();
    }

    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public void atualizar(Custos custo){
        Custos c = this.repository.getReferenceById(custo.getId());
        c.setValor(custo.getValor());
    }
}
