package com.sed.sed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @JsonIgnore
    //para não ser reduntante junto com a conta e quando puxar do banco de dado, não ter que puxar cada um toda vez
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Conta> conta;

    public ArrayList<Conta> getConta() {
        return conta;
    }

    public void setConta(ArrayList<Conta> conta) {
        this.conta = conta;
    }

    public Cliente(){

    }
    //se o id vai ser gerado automaticmanete, nao precisa ser iniciado no construtor
    public Cliente(String nome, ArrayList<Conta> conta) {
       this.nome = nome;
       this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
