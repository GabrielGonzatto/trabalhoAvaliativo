package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
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

    public List<Mecanico> listarMecanicos(){

        return this.repository.findAll();
    }

    public void editarMecanico(Mecanico mecanico){

        Mecanico m = this.repository.getReferenceById(mecanico.getId());

        m.setNome(mecanico.getNome());
        m.setCpf(mecanico.getCpf());
        m.setLogin(mecanico.getLogin());
        m.setSenha(mecanico.getSenha());
        m.setPermissao(mecanico.getPermissao());
        m.setSalario(mecanico.getSalario());
    }

    public void deletarMecanico(Long id){

        this.repository.deleteById(id);
    }



}