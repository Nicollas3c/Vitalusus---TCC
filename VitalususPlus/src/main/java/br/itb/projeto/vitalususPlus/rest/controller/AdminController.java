package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Admin;
import br.itb.projeto.vitalususPlus.model.entity.Admin;
import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import br.itb.projeto.vitalususPlus.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vitalusus/admin")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }
    @GetMapping("findAll")
    public ResponseEntity<List<Admin>> findAll(){
        List<Admin> administradores = this.adminService.findAll();
        return new ResponseEntity<List<Admin>>(administradores, HttpStatus.OK);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Admin> findById(@PathVariable long id){
        Admin admin = this.adminService.findById(id);
        return new ResponseEntity<Admin>(admin, HttpStatus.OK);
    }
    @PostMapping("post")
    public ResponseEntity<Admin> salvarAdmin(@RequestBody @Valid Admin admin){
        Usuario usuario = admin.getUsuario();
        Admin adminSalvo = this.adminService.save(admin, usuario);
        return new ResponseEntity<Admin>(adminSalvo, HttpStatus.OK);
    }
    @PutMapping("inativate")
    public ResponseEntity<Admin> deletarAdmin(@RequestBody Admin admin){
        Usuario usuario = admin.getUsuario();
        Admin adminInativate = adminService.inativate(admin, usuario);
        return new ResponseEntity<Admin>(adminInativate, HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<Admin> updateAdmin(@RequestBody @Valid Admin admin){
        Usuario usuario = admin.getUsuario();
        Admin adminUpdatado = this.adminService.update(admin, usuario);
        return new ResponseEntity<Admin>(adminUpdatado, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> erro = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError)error).getField();
            String erroMessage = error.getDefaultMessage();
            erro.put(fieldName, erroMessage);
        });
        return erro;
    }
}
