package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Aluno;
import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import br.itb.projeto.vitalususPlus.model.repository.AlunoRepository;
import br.itb.projeto.vitalususPlus.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;
    private UsuarioService usuarioService;
    private EvolucaoService evolucaoService;

    public AlunoService(AlunoRepository alunoRepository,
                        UsuarioService usuarioService,
                        EvolucaoService evolucaoService) {
        super();
        this.alunoRepository = alunoRepository;
        this.usuarioService = usuarioService;
        this.evolucaoService = evolucaoService;
    }
    public List<Aluno> findAll(){
        List<Aluno> listaAlunos = alunoRepository.findAll();
        return listaAlunos;
    }
    public Aluno findById(long id) {
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        return aluno.orElseThrow(() -> new RuntimeException(
                "Aluno não encontrado"
        ));
    }
    public Aluno save(Aluno aluno){
        aluno.setId(null);
        return alunoRepository.save(aluno);
    }
    public void delete(Aluno aluno) {
        alunoRepository.delete(aluno);
    }
    public Aluno update(Aluno aluno){
        return alunoRepository.save(aluno);
    }
}
