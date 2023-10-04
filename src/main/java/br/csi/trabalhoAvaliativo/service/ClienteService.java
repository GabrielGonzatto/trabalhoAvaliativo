package br.csi.trabalhoAvaliativo.service;

import br.csi.trabalhoAvaliativo.model.cliente.Cliente;
import br.csi.trabalhoAvaliativo.model.cliente.ClienteDTO;
import br.csi.trabalhoAvaliativo.model.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public void cadastrarCliente(Cliente cliente){

        this.repository.save(cliente);
    }

    public List<ClienteDTO> listarClientes(){

        return this.repository.findAllBy();
    }

    public Cliente findById(Long id){
        return this.repository.findById(id).get();
    }

    public void editarCliente(Cliente cliente){

        Cliente c = this.repository.getReferenceById(cliente.getId());

        c.setNome(cliente.getNome());
        c.setCpf(cliente.getCpf());
        c.setLogin(cliente.getLogin());
        c.setSenha(cliente.getSenha());
        c.setPermissao(cliente.getPermissao());
        c.setTelefone(cliente.getTelefone());
    }

    public void deletarCliente(Long id){

        this.repository.deleteById(id);
    }
}
