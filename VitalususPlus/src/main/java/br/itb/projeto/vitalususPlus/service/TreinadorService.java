package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Treinador;
import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import br.itb.projeto.vitalususPlus.model.repository.TreinadorRepository;
import br.itb.projeto.vitalususPlus.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinadorService {
    private TreinadorRepository treinadorRepository;

    public TreinadorService(TreinadorRepository treinadorRepository) {
        super();
        this.treinadorRepository = treinadorRepository;
    }
    public List<Treinador> findAll(){
        List<Treinador> listaTreinadores = treinadorRepository.findAll();
        return listaTreinadores;
    }
    public Treinador findById(long id) {
        Optional<Treinador> treinador = this.treinadorRepository.findById(id);
        return treinador.orElseThrow(() -> new RuntimeException(
                "treinador não encontrado"
        ));
    }
    public Treinador save(Treinador treinador){
        treinador.setId(null);
        return treinadorRepository.save(treinador);
    }
    public void delete(Treinador treinador) {
        this.treinadorRepository.delete(treinador);
    }
    public Treinador update(Treinador treinador){
        return treinadorRepository.save(treinador);
    }
}