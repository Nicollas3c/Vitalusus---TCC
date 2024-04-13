package br.itb.projeto.vitalususPlus.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Administrador")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int codAdmin;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToMany
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JoinTable(name = "admin_usuario",
			joinColumns = {@JoinColumn(name = "admin_id")},
			inverseJoinColumns = {@JoinColumn(name = "usuario_id")})
	private List<Usuario> listaUsuarios;
}