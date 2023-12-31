package com.sed.sed.controller;

import com.sed.sed.model.Cliente;
import com.sed.sed.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/clientes") // define a rota -URI
public class ClienteController {

    // o controller acessa as regras de negocio para fazer a ponte entre back e front
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente){
        return clienteService.criarCliente(cliente);
    }
    
    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }
}
