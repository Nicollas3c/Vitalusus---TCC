package com.itb.tcc.Vitalusus.h.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="treinadores")
public class Treinador {
	@Id // Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Fazer a classe Usuário e dar extend na classe Cliente.
	// Igual no diagrama de classes.
	
}
