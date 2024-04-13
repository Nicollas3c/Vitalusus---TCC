package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Comentario;
import br.itb.projeto.vitalususPlus.model.entity.Videoaula;
import br.itb.projeto.vitalususPlus.service.ComentarioService;
import br.itb.projeto.vitalususPlus.service.VideoaulaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitalusus/videoaula")
public class VideoaulaController {
    private VideoaulaService videoaulaService;

    public VideoaulaController(VideoaulaService videoaulaService) {
        super();
        this.videoaulaService = videoaulaService;
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
    public ResponseEntity<Videoaula> salvarVideoaula(@RequestBody Videoaula videoaula){
        Videoaula videoaulaSalvo = this.videoaulaService.save(videoaula);
        return new ResponseEntity<Videoaula>(videoaulaSalvo, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public void deletarVideoaula(@RequestBody Videoaula videoaula){
        this.videoaulaService.delete(videoaula);
    }
    @PutMapping("update")
    public ResponseEntity<Videoaula> updateVideoaula(@RequestBody Videoaula videoaula){
        Videoaula videoaulaUpdatado = this.videoaulaService.update(videoaula);
        return new ResponseEntity<Videoaula>(videoaulaUpdatado, HttpStatus.OK);
    }
}
