package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Evolucao")
public class Evolucao{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float imc;
	private float metBasal;
	private float pesoAtual;
	private float alturaAtual;

	@OneToOne
	@JoinColumn(name = "aluno_id",nullable=false)
	private Aluno aluno;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}

	public float getMetBasal() {
		return metBasal;
	}

	public void setMetBasal(float metBasal) {
		this.metBasal = metBasal;
	}

	public float getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(float pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public float getAlturaAtual() {
		return alturaAtual;
	}

	public void setAlturaAtual(float alturaAtual) {
		this.alturaAtual = alturaAtual;
	}

}
