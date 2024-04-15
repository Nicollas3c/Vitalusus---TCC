package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Evolucao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Evolucao{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="imc")
	private float imc;

	@Column(name = "met_basal")
	private float metBasal;

	@Column(name = "peso_atual")
	private float pesoAtual;

	@Column(name= "altura_atual")
	private float alturaAtual;

	@OneToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

}
