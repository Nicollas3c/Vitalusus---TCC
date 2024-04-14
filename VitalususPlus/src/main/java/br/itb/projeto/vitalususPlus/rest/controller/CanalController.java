package br.itb.projeto.vitalususPlus.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import br.itb.projeto.vitalususPlus.model.entity.Canal;
import br.itb.projeto.vitalususPlus.model.entity.Treinador;
import br.itb.projeto.vitalususPlus.service.CanalService;
import br.itb.projeto.vitalususPlus.service.TreinadorService;

@RestController
@CrossOrigin(origins = "*")
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
	    public ResponseEntity<Canal> salvarCanal(@RequestBody @Valid Canal canal){
	        Canal canalSalvo = this.canalService.save(canal);
	        return new ResponseEntity<Canal>(canalSalvo, HttpStatus.OK);
	    }
	    @DeleteMapping("delete")
	    public void deletarCanal(@RequestBody Canal canal){
	        this.canalService.delete(canal);
	    }
	    @PutMapping("update")
	    public ResponseEntity<Canal> updateCanal(@RequestBody @Valid Canal canal){
	        Canal canalUpdatado = this.canalService.update(canal);
	        return new ResponseEntity<Canal>(canalUpdatado, HttpStatus.OK);
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
