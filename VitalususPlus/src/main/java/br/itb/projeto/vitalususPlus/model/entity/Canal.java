package br.itb.projeto.vitalususPlus.model.entity;

public class Canal extends Treinador {
	private long codigo;
	private long visualizacoes;
	private long seguidores;
	private String nome;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public long getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(long visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public long getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(long seguidores) {
		this.seguidores = seguidores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
