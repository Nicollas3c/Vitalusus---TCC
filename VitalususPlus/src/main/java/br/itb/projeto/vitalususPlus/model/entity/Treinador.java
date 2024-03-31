package br.itb.projeto.vitalususPlus.model.entity;

import java.time.LocalDateTime;

public class Treinador extends Usuario {
	private int cref;
	private LocalDateTime dataNasc;
	private Banco banco;

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public int getCref() {
		return cref;
	}

	public void setCref(int cref) {
		this.cref = cref;
	}

	public LocalDateTime getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDateTime dataNasc) {
		this.dataNasc = dataNasc;
	}

}
