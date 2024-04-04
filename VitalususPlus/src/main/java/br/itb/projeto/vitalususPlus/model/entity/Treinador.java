package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Treinador")
public class Treinador{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int cref;
	private LocalDateTime dataNasc;

	@ManyToOne
	@JoinColumn(name = "banco_id",nullable=false)
	private Banco banco;

	@OneToOne
	@JoinColumn(name = "usuario_id",nullable=false)
	private Usuario usuario;

	@OneToMany
	@JoinColumn(name = "videoaula_id",nullable=false)
	private List<Videoaula> videoaula;

	@OneToOne
	@JoinColumn(name = "canal_id",nullable=false)
	private Canal canal;

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
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

	public List<Videoaula> getVideoaula() {
		return videoaula;
	}

	public void setVideoaula(List<Videoaula> videoaula) {
		this.videoaula = videoaula;
	}
}
