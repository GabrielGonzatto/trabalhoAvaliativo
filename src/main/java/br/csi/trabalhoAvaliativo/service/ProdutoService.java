package br.csi.trabalhoAvaliativo.service;


import br.csi.trabalhoAvaliativo.model.produto.Produto;
import br.csi.trabalhoAvaliativo.model.produto.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoService (ProdutoRepository repository){
        this.repository = repository;
    }

    public void cadastrarProduto(Produto produto){
        this.repository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return this.repository.findAll();
    }

    public Produto listarProduto(Long id){
        return this.repository.findById(id).get();
    }

    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public void atualizar(Produto produto){
        Produto p = this.repository.getReferenceById(produto.getId());
        p.setNome(produto.getNome());
    }
}
