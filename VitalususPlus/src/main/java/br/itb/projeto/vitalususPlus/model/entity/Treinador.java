package br.itb.projeto.vitalususPlus.model.entity;

import br.itb.projeto.vitalususPlus.validation.constraints.CREF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
	@NotBlank(message = "campo não preenchido")
	@CREF(message ="campo inválido")
	private String cref;

	@Column(name="dataNasc")
	private Date dataNasc;

	@OneToOne
	@JoinColumn(name = "usuario_id",nullable=false)
	private Usuario usuario;
}
