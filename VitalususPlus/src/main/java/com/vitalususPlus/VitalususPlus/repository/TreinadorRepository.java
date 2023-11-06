package com.vitalususPlus.VitalususPlus.repository;

import com.vitalususPlus.VitalususPlus.model.Treinador;
import com.vitalususPlus.VitalususPlus.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TreinadorRepository extends CrudRepository<Treinador,String> {
    @Query(value="SELECT * FROM treinador c WHERE c.id=?", nativeQuery = true)
    Treinador findById(Long id);
}
