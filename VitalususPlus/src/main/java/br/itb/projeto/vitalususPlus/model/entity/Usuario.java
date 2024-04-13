package br.itb.projeto.vitalususPlus.model.entity;

import java.time.LocalDateTime;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
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
	private String nome;
	
	@Column(name="email")
	private String email;
	
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
