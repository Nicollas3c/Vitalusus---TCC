package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Treinador")
public class Treinador{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="cref")
	private int cref;

	@Column(name="dataNasc")
	private Date dataNasc;

	@OneToOne
	@JoinColumn(name = "usuario_id",nullable=false)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCref() {
		return cref;
	}

	public void setCref(int cref) {
		this.cref = cref;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

}
