package com.sed.sed.repository;

import com.sed.sed.model.Conta;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

// primeiro parametro é o modelo que vai referenciar
// segundo parametro é a chave primaria do modelo
public interface ContaRepository extends JpaRepository<Conta, Id> {
}
