package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Comentario;
import br.itb.projeto.vitalususPlus.model.entity.Evolucao;
import br.itb.projeto.vitalususPlus.service.ComentarioService;
import br.itb.projeto.vitalususPlus.service.EvolucaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitalusus/evolucao")
public class EvolucaoController {
    private EvolucaoService evolucaoService;

    public EvolucaoController(EvolucaoService evolucaoService) {
        super();
        this.evolucaoService = evolucaoService;
    }
    @GetMapping("findAll")
    public ResponseEntity<List<Evolucao>> findAll(){
        List<Evolucao> evolucoes = this.evolucaoService.findAll();
        return new ResponseEntity<List<Evolucao>>(evolucoes, HttpStatus.OK);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Evolucao> findById(@PathVariable long id){
        Evolucao evolucao = this.evolucaoService.findById(id);
        return new ResponseEntity<Evolucao>(evolucao, HttpStatus.OK);
    }
    @PostMapping("post")
    public ResponseEntity<Evolucao> salvarEvolucao(@RequestBody Evolucao evolucao){
        Evolucao evolucaoSalvo = this.evolucaoService.save(evolucao);
        return new ResponseEntity<Evolucao>(evolucaoSalvo, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public void deletarEvolucao(@RequestBody Evolucao evolucao){
        this.evolucaoService.delete(evolucao);
    }
    @PutMapping("update")
    public ResponseEntity<Evolucao> updateEvolucao(@RequestBody Evolucao evolucao){
        Evolucao evolucaoUpdatado = this.evolucaoService.update(evolucao);
        return new ResponseEntity<Evolucao>(evolucaoUpdatado, HttpStatus.OK);
    }
}
