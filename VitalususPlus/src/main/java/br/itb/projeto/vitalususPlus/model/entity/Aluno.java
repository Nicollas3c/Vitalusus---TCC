package br.itb.projeto.vitalususPlus.model.entity;

import java.time.LocalDateTime;

public class Aluno extends Usuario {
	private long codigo;
	private LocalDateTime dataNasc;
	private float altura;
	private float peso;
	private Evolucao evolucao;

	public Evolucao getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(Evolucao evolucao) {
		this.evolucao = evolucao;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDateTime dataNasc) {
		this.dataNasc = dataNasc;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

}
