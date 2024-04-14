package br.itb.projeto.vitalususPlus.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Canal")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Canal{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "visualizacoes")
	private long visualizacoes;

	@NotBlank(message = "campo não preenchido")
	@Column(name = "nome")
	private String nome;

	@ManyToMany
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JoinTable(name="Aluno_segue_canal", joinColumns=
			{@JoinColumn(name="canal_id")}, inverseJoinColumns=
			{@JoinColumn(name="seguidor_id")})
	private List<Aluno> alunos;
	private Integer seguidores;
	@OneToOne
	@JoinColumn(name = "treinador_id")
	private Treinador treinador;

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}
}
