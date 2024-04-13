package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Administrador")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int codAdmin;

	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "admin_usuario",
			joinColumns = {@JoinColumn(name="admin_id")},
			inverseJoinColumns = {@JoinColumn(name="usuario_id")} )
	private List<Usuario> listaUsuarios;

	public int getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
