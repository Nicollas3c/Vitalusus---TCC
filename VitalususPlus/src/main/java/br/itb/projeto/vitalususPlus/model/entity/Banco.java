package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Banco")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="numeroCartao")
    private Long numeroCartao;

    @OneToOne
    @JoinColumn(name="treinador_id")
    private Treinador treinaodor;

    public Treinador getTreinaodor() {
        return treinaodor;
    }

    public void setTreinaodor(Treinador treinaodor) {
        this.treinaodor = treinaodor;
    }

    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
