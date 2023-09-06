package com.itb.tcc.Vitalusus.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb.tcc.Vitalusus.h.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}