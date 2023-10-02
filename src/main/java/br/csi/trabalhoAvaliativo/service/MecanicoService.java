package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.mecanico.Mecanico;
import br.csi.trabalhoAvaliativo.model.mecanico.MecanicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MecanicoService {

    private MecanicoRepository repository;
    public MecanicoService(MecanicoRepository repository) {
        this.repository = repository;
    }

    public void cadastroMecanico(Mecanico mecanico){
        this.repository.save(mecanico);
    }



}
