package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Videoaula")
public class Videoaula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String link;

	private String descricao;
	private String titulo;
	private long likes;
	private long deslikes;
	private long visualizacoes;

	@OneToOne
	@JoinColumn(name = "canal_id")
	private Canal canal;

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	@ManyToMany
	@JoinTable(name="Aluno_videoaula", joinColumns=
			{@JoinColumn(name="videoaula_id")}, inverseJoinColumns=
			{@JoinColumn(name="aluno_id")})
	private List<Aluno> alunos;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public long getDeslikes() {
		return deslikes;
	}

	public void setDeslikes(long deslikes) {
		this.deslikes = deslikes;
	}

	public long getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(long visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

}