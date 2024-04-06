package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name="Admin_aluno", joinColumns=
			{@JoinColumn(name="administrador_id")}, inverseJoinColumns=
			{@JoinColumn(name="aluno_id")})
	private List<Aluno> alunos;

	@ManyToMany
	@JoinTable(name="Admin_treinador", joinColumns=
			{@JoinColumn(name="administrador_id")}, inverseJoinColumns=
			{@JoinColumn(name="treinador_id")})
	private List<Treinador> treinadores;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Treinador> getTreinadores() {
		return treinadores;
	}

	public void setTreinadores(List<Treinador> treinadores) {
		this.treinadores = treinadores;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
