package com.itb.tcc.Vitalusus.h.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.tcc.Vitalusus.h.model.Cliente;

// http://localhost:8080/Vitalusus-2h/

@Controller
@RequestMapping("/Vitalusus-2h/Clientes")
public class AcademiaController {
	List<Cliente> listaDeClientes = new ArrayList<Cliente>();
	@GetMapping("/clientes")
	public String listarClientes(Model model) {
		
		Cliente cliente0 = new Cliente();
		cliente0.setId(0);
		cliente0.setNome("Otta Fidela");
		cliente0.setCodStatus(true);
		cliente0.setDataDeNascimento(12,05,2006);
		cliente0.setEmail("ottafifidela@gmail.com");
		cliente0.setSenha("otta123");
		cliente0.setTelefone("11 1234-5678");
		cliente0.setTipoPessoa("Aluno(a)");
		cliente0.setCpf("557-282-465-19");
		
		// Cliente na ArrayList
		
		listaDeClientes.add(cliente0);
		
		model.addAttribute("listaDeClientes", listaDeClientes);
		
		return "clientes";
	}
}
