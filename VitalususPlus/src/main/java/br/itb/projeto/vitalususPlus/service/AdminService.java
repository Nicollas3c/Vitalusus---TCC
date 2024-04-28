package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Admin;
import br.itb.projeto.vitalususPlus.model.entity.Admin;
import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import br.itb.projeto.vitalususPlus.model.repository.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepository adminRepository;
    private UsuarioService usuarioService;

    public AdminService(AdminRepository adminRepository, UsuarioService usuarioService) {
        super();
        this.adminRepository = adminRepository;
        this.usuarioService = usuarioService;
    }
    public List<Admin> findAll(){
        List<Admin> listaAdministradores = adminRepository.findAll();
        return listaAdministradores;
    }
    public Admin findById(long id) {
        Optional<Admin> admin = this.adminRepository.findById(id);
        return admin.orElseThrow(() -> new RuntimeException(
                "Admin não encontrado"
        ));
    }
    public Admin save(Admin admin, Usuario usuario){
        admin.setId(null);
        usuario = admin.getUsuario();
        usuario.setStatusUsuario("ATIVO");
        usuario.setTipoUsuario("ADMINISTRADOR");
        usuario.setNivelAcesso("ADMIN");
        if (admin.getListaUsuarios()==null){
            admin.setListaUsuarios(new ArrayList<>());
        }
        admin.setNumeroUsuarios(admin.getListaUsuarios().size());
        return adminRepository.save(admin);
    }
    public Admin inativate(Admin admin, Usuario usuario) {
        usuario = admin.getUsuario();
        usuario.setStatusUsuario("INATIVO");
        usuario.setTipoUsuario("ADMINISTRADOR");
        usuario.setNivelAcesso("ADMIN");
        if (admin.getListaUsuarios()==null){
            admin.setListaUsuarios(new ArrayList<>());
        }
        admin.setNumeroUsuarios(admin.getListaUsuarios().size());
        return adminRepository.save(admin);
    }
    public Admin update(Admin admin, Usuario usuario){
        usuario = admin.getUsuario();
        usuario.setStatusUsuario("ATIVO");
        usuario.setTipoUsuario("ADMINISTRADOR");
        usuario.setNivelAcesso("ADMIN");
        if (admin.getListaUsuarios()==null){
            admin.setListaUsuarios(new ArrayList<>());
        }
        admin.setNumeroUsuarios(admin.getListaUsuarios().size());
        return adminRepository.save(admin);
    }
}
