package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Canal")
public class Canal{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "visualizacoes")
	private long visualizacoes;

	@Column(name = "nome")
	private String nome;

	@ManyToMany
	@JoinTable(name="Aluno_segue_canal", joinColumns=
			{@JoinColumn(name="canal_id")}, inverseJoinColumns=
			{@JoinColumn(name="seguidor_id")})
	private List<Aluno> seguidores;

	public List<Aluno> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Aluno> seguidores) {
		this.seguidores = seguidores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
