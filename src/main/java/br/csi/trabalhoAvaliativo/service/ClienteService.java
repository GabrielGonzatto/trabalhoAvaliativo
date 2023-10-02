package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public void cadastrarCliente(Cliente cliente){

        this.repository.save(cliente);
    }
}
