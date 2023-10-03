package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.produtoCusto.ProdutoCusto;
import br.csi.trabalhoAvaliativo.model.produtoCusto.ProdutoCustoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCustoService {
    private ProdutoCustoRepository repository;

    public ProdutoCustoService(ProdutoCustoRepository repository){
        this.repository = repository;
    }

    public void cadastrarProdutoCusto(ProdutoCusto produtoCusto){
        this.repository.save(produtoCusto);
    }

    public List<ProdutoCusto> listarProdutosCustos(){
        return this.repository.findAll();
    }

    public ProdutoCusto findById(Long id){
        return this.repository.findById(id).get();
    }

    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public void atualizar(ProdutoCusto produtoCusto){
        ProdutoCusto p = this.repository.getReferenceById(produtoCusto.getId());
        p.setNome(produtoCusto.getNome());

    }
}
