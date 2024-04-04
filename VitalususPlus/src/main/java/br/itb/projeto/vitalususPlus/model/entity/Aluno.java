package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Aluno")
public class Aluno{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime dataNasc;
	private float altura;
	private float peso;

	@ManyToMany
	@JoinTable(name="aluno_segue_canal", joinColumns=
			{@JoinColumn(name="seguidor_id")}, inverseJoinColumns=
			{@JoinColumn(name="canal_id")})
	private List<Canal> canais;

	@OneToOne
	@JoinColumn(name = "usuario_id",nullable=false)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Canal> getCanais() {
		return canais;
	}

	public void setCanais(List<Canal> canais) {
		this.canais=canais;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
