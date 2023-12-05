package com.vitalusus.vitalususplus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vitalusus.vitalususplus.model.Treinador;
import com.vitalusus.vitalususplus.model.Usuario;

public interface TreinadorRepository extends CrudRepository<Treinador,String> {
    @Query(value="SELECT * FROM treinador c WHERE c.id=?", nativeQuery = true)
    Treinador findById(Long id);
    
    @Query(value="SELECT * FROM treinador c WHERE c.cref=?", nativeQuery = true)
    Treinador findByCref(String cref);
}
