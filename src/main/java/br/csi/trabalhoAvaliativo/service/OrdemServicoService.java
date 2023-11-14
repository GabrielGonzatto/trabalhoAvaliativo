package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.custo.Custo;
import br.csi.trabalhoAvaliativo.model.ordem_servico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrdemServicoService {
    private OrdemServicoRepository repository;
    @Autowired
    private CustoService custoService;
    private double total = 0;

    public OrdemServicoService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarOrdemServico(OrdemServico ordemServico){
        ordemServico.setAtivo(true);
        ordemServico.setStatus("aberto");
        ordemServico.setData_entrada(getData());

        this.repository.save(ordemServico);
    }

    public List<OrdemServico> listarOrdensServicos(){
        return this.repository.findAll();
    }

    public OrdemServico listarOrdemServico(Long id){
        return this.repository.findById(id).get();
    }

    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public void atualizar(OrdemServico ordemServico){
        OrdemServico o = this.repository.getReferenceById(ordemServico.getId());

        o.setMarca(ordemServico.getMarca());
        o.setModelo(ordemServico.getModelo());
        o.setTipo(ordemServico.getTipo());
        o.setStatus(ordemServico.getStatus());
        o.setTotal(ordemServico.getTotal());
        o.setProblema(ordemServico.getProblema());
        o.setData_entrada(ordemServico.getData_entrada());
        o.setData_saida(ordemServico.getData_saida());
        o.setAtivo(ordemServico.getAtivo());

        for (Custo custo : ordemServico.getCustos()) {
            custo.setOrdemServico(ordemServico);
            custoService.atualizar(custo);
        }
    }

    public void fecharOrdemServico(OrdemServico ordemServico){
        OrdemServico o = this.repository.getReferenceById(ordemServico.getId());

        o.setTotal(calculaTotal(ordemServico));
        o.setData_saida(getData());
        o.setAtivo(false);
        o.setStatus("Fechada");

        for (Custo custo : ordemServico.getCustos()) {
            custo.setOrdemServico(ordemServico);
            custoService.cadastrarCusto(custo);
        }

    }

    public String getData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.format(formatter);
    }

    public double calculaTotal(OrdemServico ordemServico){
        this.total = 0.0;

        for (Custo custo : ordemServico.getCustos()){
            this.total = this.total + custo.getValor();
        }

        return this.total;
    }
}
