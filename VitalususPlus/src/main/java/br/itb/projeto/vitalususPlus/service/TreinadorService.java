package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Treinador;
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
    private UsuarioService usuarioService;

    public TreinadorService(TreinadorRepository treinadorRepository, UsuarioService usuarioService) {
        super();
        this.treinadorRepository = treinadorRepository;
        this.usuarioService = usuarioService;
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
    public Treinador save(Treinador treinador, Usuario usuario){
        treinador.setId(null);
        usuario = treinador.getUsuario();
        usuario.setStatusUsuario("ATIVO");
        usuario.setTipoUsuario("TREINADOR");
        usuario.setNivelAcesso("USER");
        return treinadorRepository.save(treinador);
    }
    public Treinador inativate(Treinador treinador, Usuario usuario) {
        usuario = treinador.getUsuario();
        usuario.setTipoUsuario("TREINADOR");
        usuario.setNivelAcesso("USER");
        return treinadorRepository.save(treinador);
    }
    public Treinador update(Treinador treinador, Usuario usuario){
        usuario = treinador.getUsuario();
        usuario.setStatusUsuario("ATIVO");
        usuario.setTipoUsuario("TREINADOR");
        usuario.setNivelAcesso("USER");
        return treinadorRepository.save(treinador);
    }
}
