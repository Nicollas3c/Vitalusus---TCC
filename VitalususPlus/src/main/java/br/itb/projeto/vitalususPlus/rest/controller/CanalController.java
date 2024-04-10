package br.itb.projeto.vitalususPlus.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.vitalususPlus.model.entity.Canal;
import br.itb.projeto.vitalususPlus.model.entity.Treinador;
import br.itb.projeto.vitalususPlus.service.CanalService;
import br.itb.projeto.vitalususPlus.service.TreinadorService;

@RestController
@RequestMapping("/vitalusus/canal")
public class CanalController {
	   private CanalService canalService;

	    public CanalController(CanalService canalService) {
	        super();
	        this.canalService = canalService;
	    }
	    @GetMapping("findAll")
	    public ResponseEntity<List<Canal>> findAll(){
	        List<Canal> canais = this.canalService.findAll();
	        return new ResponseEntity<List<Canal>>(canais, HttpStatus.OK);
	    }
	    @GetMapping("findById/{id}")
	    public ResponseEntity<Canal> findById(@PathVariable long id){
	        Canal canal = this.canalService.findById(id);
	        return  new ResponseEntity<Canal>(canal, HttpStatus.OK);
	    }
	    @PostMapping("post")
	    public ResponseEntity<Canal> salvarCanal(@RequestBody Canal canal){
	        Canal canalSalvo = this.canalService.save(canal);
	        return new ResponseEntity<Canal>(canalSalvo, HttpStatus.OK);
	    }
	    @DeleteMapping("delete")
	    public void deletarCanal(@RequestBody Canal canal){
	        this.canalService.delete(canal);
	    }
	    @PutMapping("update")
	    public ResponseEntity<Canal> updateCanal(@RequestBody Canal canal){
	        Canal canalUpdatado = this.canalService.update(canal);
	        return new ResponseEntity<Canal>(canalUpdatado, HttpStatus.OK);
	    }
}
