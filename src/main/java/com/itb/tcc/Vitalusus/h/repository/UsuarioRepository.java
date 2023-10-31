package com.itb.tcc.Vitalusus.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itb.tcc.Vitalusus.h.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value="SELECT * FROM cleinte c WHERE c.email=? AND c.senha=?", nativeQuery = true)
	Usuario findByEmail (String email);
	
}
