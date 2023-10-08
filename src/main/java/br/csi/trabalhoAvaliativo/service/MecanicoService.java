package br.csi.trabalhoAvaliativo.service;


import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import br.csi.trabalhoAvaliativo.model.mecanico.MecanicoDTO;
import br.csi.trabalhoAvaliativo.model.mecanico.MecanicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoService {

    private MecanicoRepository repository;

    public MecanicoService(MecanicoRepository repository){
        this.repository = repository;
    }

    public void cadastrarMecanico(Mecanico mecanico){

        this.repository.save(mecanico);
    }

    public List<MecanicoDTO> listarMecanicos(){
        return this.repository.findAllBy();
    }

    public Mecanico findById(Long id){
        return this.repository.findById(id).get();
    }

    public void editarMecanico(Mecanico mecanico){

        Mecanico m = this.repository.getReferenceById(Long.valueOf(mecanico.getIdMecanico()));

        m.setNome(mecanico.getNome());
        m.setCpf(mecanico.getCpf());
        m.setSalario(mecanico.getSalario());
    }

    public void deletarMecanico(Long id){

        this.repository.deleteById(id);
    }



}
