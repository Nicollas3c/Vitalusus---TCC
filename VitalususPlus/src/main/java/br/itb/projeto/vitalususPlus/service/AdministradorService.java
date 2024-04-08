package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Administrador;
import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import br.itb.projeto.vitalususPlus.model.repository.AdministradorRepository;
import br.itb.projeto.vitalususPlus.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {
    private AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        super();
        this.administradorRepository = administradorRepository;
    }
    public List<Administrador> findAll(){
        List<Administrador> listaAdministradores = administradorRepository.findAll();
        return listaAdministradores;
    }
    public Administrador findById(long id) {
        Optional<Administrador> administrador = this.administradorRepository.findById(id);
        return administrador.orElseThrow(() -> new RuntimeException(
                "Administrador não encontrado"
        ));
    }
    public Administrador save(Administrador administrador){
        administrador.setId(null);
        return administradorRepository.save(administrador);
    }
    public void delete(Administrador administrador) {
        this.administradorRepository.delete(administrador);
    }
    public Administrador update(Administrador administrador){
        return administradorRepository.save(administrador);
    }
}
