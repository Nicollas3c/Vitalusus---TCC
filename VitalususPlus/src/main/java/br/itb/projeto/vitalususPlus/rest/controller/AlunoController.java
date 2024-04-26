package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Admin;
import br.itb.projeto.vitalususPlus.model.entity.Aluno;
import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import br.itb.projeto.vitalususPlus.service.AdminService;
import br.itb.projeto.vitalususPlus.service.AlunoService;
import br.itb.projeto.vitalususPlus.service.UsuarioService;
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
@RequestMapping("/vitalusus/aluno")
public class AlunoController {
    private AlunoService alunoService;
    private UsuarioService usuarioService;

    public AlunoController(AlunoService alunoService, UsuarioService usuarioService) {
        super();
        this.alunoService = alunoService;
        this.usuarioService = usuarioService;
    }
    @GetMapping("findAll")
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> alunos = this.alunoService.findAll();
        return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        Aluno aluno = this.alunoService.findById(id);
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
    }
    @PostMapping("post")
    public ResponseEntity<Aluno> salvarAluno(@RequestBody @Valid Aluno aluno){
        Usuario usuario = aluno.getUsuario();
        Aluno alunoSalvo = this.alunoService.save(aluno, usuario);
        if (alunoSalvo != null) usuarioService.save(usuario);
        return new ResponseEntity<Aluno>(alunoSalvo, HttpStatus.OK);
    }
    @PutMapping("inativate")
    public ResponseEntity<Aluno> deletarAluno(@RequestBody Aluno aluno){
        Usuario usuario = aluno.getUsuario();
        Aluno alunoInativate = alunoService.inativate(aluno, usuario);
        if (alunoInativate != null) usuarioService.save(usuario);
        return new ResponseEntity<Aluno>(alunoInativate, HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<Aluno> updateAdmin(@RequestBody @Valid Aluno aluno){
        Usuario usuario = aluno.getUsuario();
        Aluno alunoUpdatado = this.alunoService.update(aluno, usuario);
        if (alunoUpdatado != null) usuarioService.save(usuario);
        return new ResponseEntity<Aluno>(alunoUpdatado, HttpStatus.OK);
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
