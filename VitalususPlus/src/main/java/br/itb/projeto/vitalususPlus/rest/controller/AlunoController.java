package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Admin;
import br.itb.projeto.vitalususPlus.model.entity.Aluno;
import br.itb.projeto.vitalususPlus.service.AdminService;
import br.itb.projeto.vitalususPlus.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitalusus/aluno")
public class AlunoController {
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        super();
        this.alunoService = alunoService;
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
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno){
        Aluno alunoSalvo = this.alunoService.save(aluno);
        return new ResponseEntity<Aluno>(alunoSalvo, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public void deletarAluno(@RequestBody Aluno aluno){
        this.alunoService.delete(aluno);
    }
    @PutMapping("update")
    public ResponseEntity<Aluno> updateAdmin(@RequestBody Aluno aluno){
        Aluno alunoUpdatado = this.alunoService.update(aluno);
        return new ResponseEntity<Aluno>(alunoUpdatado, HttpStatus.OK);
    }
}
