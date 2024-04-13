package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Treinador")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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
}
