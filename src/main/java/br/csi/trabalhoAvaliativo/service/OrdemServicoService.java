package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.ordemservico.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    public OrdemServicoService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    private OrdemServicoRepository repository;

    public void cadastrarOrdem(OrdemServico ordemServico){
        System.out.println("entrou em salvar"+ordemServico.getId());
        ordemServico.setAtivo(true);
        this.repository.save(ordemServico);
    }
    public List<OrdemServico> listarOrdens(){
        return this.repository.findAllBy();
    }

    public OrdemServico findById(Long id){
        System.out.println("entrou em find"+id);

        return this.repository.findById(id).get();}

    public void atualizar(OrdemServico ordemServico){
        System.out.println("entrou em atualizar");

        OrdemServico o = this.repository.getReferenceById(ordemServico.getId());
        o.setMarca(ordemServico.getMarca());
        o.setModelo(ordemServico.getModelo());
        o.setTipo(ordemServico.getTipo());
        o.setProblema(ordemServico.getProblema());
        o.setStatus(ordemServico.getStatus());
        o.setDataEntrada(ordemServico.getDataEntrada());
        o.setCliente(ordemServico.getCliente());
        o.setMecanico(ordemServico.getMecanico());
    }
    public void encerrarOrdem(OrdemServico ordemServico){
        System.out.println("entrou em encerrar");

        OrdemServico o = this.repository.getReferenceById(ordemServico.getId());
        o.setAtivo(false);
        o.calcularTotal();
        o.setOrdemEncerrada(new OrdemEncerrada());
    }
    public List<OrdemServicoDTO> listarOrdensAtivas(){
        return this.repository.findAllActive();
    }
    public List<OrdemEncerradaDTO> listarOrdensInativas(){
        return this.repository.findAllInactive();
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }

}