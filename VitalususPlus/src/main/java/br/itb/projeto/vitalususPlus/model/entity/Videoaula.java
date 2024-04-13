package br.itb.projeto.vitalususPlus.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Videoaula")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Videoaula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String link;
	private String descricao;
	private String titulo;
	private long likes;
	private long deslikes;
	@ManyToMany
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JoinTable(name="aluno_videoaula",
			joinColumns = {@JoinColumn(name="videoaula_id")},
			inverseJoinColumns = {@JoinColumn(name="aluno_id")})
	private List<Aluno> alunos;
	private long visualizacoes;

	@OneToOne
	@JoinColumn(name = "canal_id")
	private Canal canal;
}
