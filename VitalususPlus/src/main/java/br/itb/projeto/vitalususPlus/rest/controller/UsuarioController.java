package br.itb.projeto.vitalususPlus.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.vitalususPlus.service.UsuarioService;

@RestController
@RequestMapping("/Vitalusus/usuario")
public class UsuarioController {
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
}
