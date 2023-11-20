package com.sed.sed.service;

import com.sed.sed.model.Cliente;
import com.sed.sed.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    //constante
    private final ClienteRepository clienteRepository;

    @Autowired //para o próprio spring boot instanciar o repositorio
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> retornarClientePeloId(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente retornarClientePeloNome(String nome){
        return clienteRepository.findByNome(nome);
    }
}
