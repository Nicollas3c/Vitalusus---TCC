package com.itb.tcc.Vitalusus.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itb.tcc.Vitalusus.h.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query(value="SELECT * FROM cliente c WHERE c.email=? AND c.senha=?", nativeQuery = true)
	Cliente findByLogin(String email,String senha);
	
}
