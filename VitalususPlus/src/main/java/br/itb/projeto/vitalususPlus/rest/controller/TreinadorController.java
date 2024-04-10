package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Treinador;
import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import br.itb.projeto.vitalususPlus.service.TreinadorService;
import br.itb.projeto.vitalususPlus.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitalusus/treinador")
public class TreinadorController {
    private TreinadorService treinadorService;
    private UsuarioService usuarioService;

    public TreinadorController(TreinadorService treinadorService, UsuarioService usuarioService) {
        super();
        this.treinadorService = treinadorService;
        this.usuarioService = usuarioService;
    }
    @GetMapping("findAll")
    public ResponseEntity<List<Treinador>> findAll(){
        List<Treinador> treinadores = this.treinadorService.findAll();
        return new ResponseEntity<List<Treinador>>(treinadores, HttpStatus.OK);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Treinador> findById(@PathVariable long id){
        Treinador treinador = this.treinadorService.findById(id);
        return  new ResponseEntity<Treinador>(treinador, HttpStatus.OK);
    }
    @PostMapping("post")
    public ResponseEntity<Treinador> salvarTreinador(@RequestBody Treinador treinador){
        Treinador treinadorSalvo = this.treinadorService.save(treinador);
        return new ResponseEntity<Treinador>(treinadorSalvo, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public void deletarTreinador(@RequestBody Treinador treinador){
        this.treinadorService.delete(treinador);
    }
    @PutMapping("update")
    public ResponseEntity<Treinador> updateTreinador(@RequestBody Treinador treinador){
        Treinador treinadorUpdatado = this.treinadorService.update(treinador);
        return new ResponseEntity<Treinador>(treinadorUpdatado, HttpStatus.OK);
    }
}
