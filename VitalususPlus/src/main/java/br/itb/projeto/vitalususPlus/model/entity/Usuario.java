package br.itb.projeto.vitalususPlus.model.entity;

import java.time.LocalDateTime;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@Entity
@Table(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome")
	@NotBlank(message = "campo não preenchido")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "nome deve inicial com letras maiúsculas")
	private String nome;

	@Email(message ="campo inválido")
	@NotBlank(message = "campo não preenchido")
	@Column(name="email")
	private String email;

	@NotBlank(message = "campo não preenchido")
	@Column(name="senha")
	private String senha;
	
	@Column(name="nivelAcesso")
	private String nivelAcesso;

	@Lob
	@Column(name="foto")
	private byte[] foto;
	
	@Column(name="dataCadastro")
	private LocalDateTime dataCadastro;

	@Column(name="statusUsuario")
	private String statusUsuario;

	@Column(name="tipoUsuario")
	private String tipoUsuario;
	
}
