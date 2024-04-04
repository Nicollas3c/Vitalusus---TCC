package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Canal")
public class Canal{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long visualizacoes;

	private String nome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(long visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
