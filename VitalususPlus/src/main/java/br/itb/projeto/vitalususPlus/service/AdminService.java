package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Admin;
import br.itb.projeto.vitalususPlus.model.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepository administradorRepository;
    private UsuarioService usuarioService;

    public AdminService(AdminRepository administradorRepository, UsuarioService usuarioService) {
        super();
        this.administradorRepository = administradorRepository;
        this.usuarioService = usuarioService;
    }
    public List<Admin> findAll(){
        List<Admin> listaAdministradores = administradorRepository.findAll();
        return listaAdministradores;
    }
    public Admin findById(long id) {
        Optional<Admin> administrador = this.administradorRepository.findById(id);
        return administrador.orElseThrow(() -> new RuntimeException(
                "Admin não encontrado"
        ));
    }
    public Admin save(Admin admin){
        admin.setId(null);
        return administradorRepository.save(admin);
    }
    public void delete(Admin admin) {
        this.administradorRepository.delete(admin);
    }
    public Admin update(Admin admin){
        return administradorRepository.save(admin);
    }
}
