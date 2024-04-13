package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Aluno;
import br.itb.projeto.vitalususPlus.model.entity.Videoaula;
import br.itb.projeto.vitalususPlus.model.repository.AlunoRepository;
import br.itb.projeto.vitalususPlus.model.repository.VideoaulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoaulaService {
    private VideoaulaRepository videoaulaRepository;

    public VideoaulaService(VideoaulaRepository videoaulaRepository) {
        super();
        this.videoaulaRepository = videoaulaRepository;
    }
    public List<Videoaula> findAll(){
        List<Videoaula> listaVideoaula = videoaulaRepository.findAll();
        return listaVideoaula;
    }
    public Videoaula findById(long id) {
        Optional<Videoaula> videoaula = this.videoaulaRepository.findById(id);
        return videoaula.orElseThrow(() -> new RuntimeException(
                "Aluno não encontrado"
        ));
    }
    public Videoaula save(Videoaula videoaula){
        videoaula.setId(null);
        return videoaulaRepository.save(videoaula);
    }
    public void delete(Videoaula videoaula) {
        this.videoaulaRepository.delete(videoaula);
    }
    public Videoaula update(Videoaula videoaula){
        return videoaulaRepository.save(videoaula);
    }
}
