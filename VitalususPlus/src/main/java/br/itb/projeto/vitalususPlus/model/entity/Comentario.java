package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="texto")
    private String texto;

    @ManyToOne
    @JoinColumn(name="aluno_id")
    private Aluno aluno;

    @OneToOne
    @JoinColumn(name="videoaula_id")
    private Videoaula videoaula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Videoaula getVideoaula() {
        return videoaula;
    }

    public void setVideoaula(Videoaula videoaula) {
        this.videoaula = videoaula;
    }
}
