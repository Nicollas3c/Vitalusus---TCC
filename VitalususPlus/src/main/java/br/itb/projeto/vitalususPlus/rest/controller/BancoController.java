package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Banco;
import br.itb.projeto.vitalususPlus.model.entity.Comentario;
import br.itb.projeto.vitalususPlus.service.BancoService;
import br.itb.projeto.vitalususPlus.service.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitalusus/banco")
public class BancoController {
    private BancoService bancoService;

    public BancoController(BancoService bancoService) {
        super();
        this.bancoService = bancoService;
    }
    @GetMapping("findAll")
    public ResponseEntity<List<Banco>> findAll(){
        List<Banco> bancos = this.bancoService.findAll();
        return new ResponseEntity<List<Banco>>(bancos, HttpStatus.OK);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Banco> findById(@PathVariable long id){
        Banco banco = this.bancoService.findById(id);
        return new ResponseEntity<Banco>(banco, HttpStatus.OK);
    }
    @PostMapping("post")
    public ResponseEntity<Banco> salvarBanco(@RequestBody Banco banco){
        Banco bancoSalvo = this.bancoService.save(banco);
        return new ResponseEntity<Banco>(bancoSalvo, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public void deletarBanco(@RequestBody Banco banco){
        this.bancoService.delete(banco);
    }
    @PutMapping("update")
    public ResponseEntity<Banco> updateBanco(@RequestBody Banco banco){
        Banco bancoUpdatado = this.bancoService.update(banco);
        return new ResponseEntity<Banco>(bancoUpdatado, HttpStatus.OK);
    }
}
