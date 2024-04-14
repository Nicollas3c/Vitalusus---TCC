package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Aluno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Aluno{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dataNasc")
	private Date dataNasc;

	@Column(name="altura")
	private float altura;

	@Column(name = "peso")
	private float peso;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
