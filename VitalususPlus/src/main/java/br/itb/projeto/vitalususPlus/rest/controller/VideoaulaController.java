package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Canal;
import br.itb.projeto.vitalususPlus.model.entity.Comentario;
import br.itb.projeto.vitalususPlus.model.entity.Videoaula;
import br.itb.projeto.vitalususPlus.service.CanalService;
import br.itb.projeto.vitalususPlus.service.ComentarioService;
import br.itb.projeto.vitalususPlus.service.VideoaulaService;
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
@RequestMapping("/vitalusus/videoaula")
public class VideoaulaController {
    private VideoaulaService videoaulaService;
    private CanalService canalService;

    public VideoaulaController(VideoaulaService videoaulaService, CanalService canalService) {
        super();
        this.videoaulaService = videoaulaService;
        this.canalService = canalService;
    }
    @GetMapping("findAll")
    public ResponseEntity<List<Videoaula>> findAll(){
        List<Videoaula> videoaulas = this.videoaulaService.findAll();
        return new ResponseEntity<List<Videoaula>>(videoaulas, HttpStatus.OK);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Videoaula> findById(@PathVariable long id){
        Videoaula videoaula = this.videoaulaService.findById(id);
        return new ResponseEntity<Videoaula>(videoaula, HttpStatus.OK);
    }
    @PostMapping("post")
    public ResponseEntity<Videoaula> salvarVideoaula(@RequestBody @Valid Videoaula videoaula){
        Canal canal = videoaula.getCanal();
        Videoaula videoaulaSalvo = this.videoaulaService.save(videoaula, canal);
        if (videoaulaSalvo !=null) canalService.update(canal);
        return new ResponseEntity<Videoaula>(videoaulaSalvo, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public void deletarVideoaula(@RequestBody Videoaula videoaula){
        this.videoaulaService.delete(videoaula);
    }
    @PutMapping("update")
    public ResponseEntity<Videoaula> updateVideoaula(@RequestBody @Valid Videoaula videoaula){
        Canal canal = videoaula.getCanal();
        Videoaula videoaulaUpdatado = this.videoaulaService.update(videoaula, canal);
        if (videoaulaUpdatado !=null) canalService.update(canal);
        return new ResponseEntity<Videoaula>(videoaulaUpdatado, HttpStatus.OK);
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
