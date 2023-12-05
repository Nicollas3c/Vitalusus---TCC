package com.vitalusus.vitalususplus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vitalusus.vitalususplus.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,String> {
    @Query(value="SELECT * FROM usuario c WHERE c.email=? AND c.senha=?", nativeQuery = true)
    Usuario findByLogin(String email, String senha);

    @Query(value="SELECT * FROM usuario c WHERE c.id=?", nativeQuery = true)
    Usuario findById(Long id);
    
    @Query(value="SELECT * FROM usuario c WHERE c.email=?", nativeQuery = true)
    Usuario findByEmail(String email);
   
}
