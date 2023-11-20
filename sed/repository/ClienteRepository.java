package com.sed.sed.repository;

import com.sed.sed.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//primeiro marametro a classe
// segundo o tipo da chave primaria
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByNome(String nome); //SELECT * FROM CLIENTE4 WHERE nome = 'nome';
    public Cliente findByNomeAndCpf(String nome, String cpf);
}



/*
Jpa Repository possui todos esses métodos implementados, quando extends JpaRepository, pode fazer todos esses métodos
- save (cliente)
- findById (id - tipo long ou int)
- findAll (todos os clientes do bando de dados - retorna lista de clientes)
- delete(cliente a ser deletado)
- deleteById (id a ser deletado)

para personalizar uma query, faz a assinatura (mas ele nao vai pedir no projeto, so os metodos que ja vem no JpaRepository
 */