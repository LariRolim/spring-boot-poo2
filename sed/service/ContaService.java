package com.sed.sed.service;

import com.sed.sed.model.Cliente;
import com.sed.sed.model.Conta;
import com.sed.sed.repository.ClienteRepository;
import com.sed.sed.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    //regra de negocio - ele precisa acessar o cliente pra checar se o cliente existe
    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Conta criarConta(Conta conta, Long idCliente){
        Optional<Cliente> optCliente = clienteRepository.findById(idCliente);

        if(optCliente.isEmpty()){
            return null;
        } else {
            optCliente.get().getConta().add(conta);
            conta.setCliente(optCliente.get());
            return contaRepository.save(conta);
        }
    }

    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }


}
