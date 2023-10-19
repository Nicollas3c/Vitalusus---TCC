package com.itb.tcc.Vitalusus.h.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itb.tcc.Vitalusus.h.repository.*;

import com.itb.tcc.Vitalusus.h.model.Cliente;

// http://localhost:8080/Vitalusus-2h/Clientes/listaClientes

@Controller
@RequestMapping("/Vitalusus-2h/Clientes")
public class ClienteController {
	List<Cliente> listaDeClientes = new ArrayList<Cliente>(); // Variável Array
	private ClienteRepository clienteRepository;
	@GetMapping("/listaClientes")
	public String listarClientes(Model model) {
		
		Cliente cliente0 = new Cliente();
		cliente0.setId(0);
		cliente0.setNome("Otta Fidela");
		cliente0.setCodStatus(true);
		cliente0.setDataDeNascimento(null);
		cliente0.setEmail("ottafifidela@gmail.com");
		cliente0.setSenha("otta123");
		cliente0.setTelefone("11 1234-5678");
		cliente0.setTipoPessoa("Aluno(a)");
		
		// Cliente na ArrayList
		
		listaDeClientes.add(cliente0);
		
		model.addAttribute("listaDeClientes", listaDeClientes);
		
		return "clientes";
	}
	
	@GetMapping("/cadastrar")
	public String novoCliente(Cliente cliente, Model model) {
		
		model.addAttribute("cliente", cliente);
		return "cadastrar";
	}
	
	// página de sucesso
	@GetMapping("clienteSucesso")
	String showPageSuccess() {
		return "clienteSucesso";
	}
	
	@PostMapping("/clienteSucesso")
	public String gravarNovoCliente(Cliente cliente) {
		listaDeClientes.add(cliente);
		cliente.setCodStatus(true);
		// Cliente clientedb = clienteRepository.save(cliente);
		return "redirect:/Vitalusus-2h/Clientes/clienteSucesso";
	} 
	
	// carregar formulário login
	
	@GetMapping("/login")
	public String showFormLogin(Cliente cliente, Model model){
		
		model.addAttribute("cliente", cliente);
		return "login";
	}
	
//	@PostMapping("/login")
//	public String efetuarLogin() {
//		String page = "redirect:/Viatlusus-2h/Clientes/login";
		// Lógica de verificação
		// Cliente clienteDb = clienteRepository.findByEmail(cliente.getEmail());
		
//		if(clienteDb != null && clienteDb.getSenha().equals(clienteDb.getSenha())) {
//			page = "redirect:/Viatlusus-2h/Clientes/perfil";
//		}
//		
//		return page;
//	}
	
	@GetMapping("/esqueceuSenha")
	public String esqueceuSenha(Cliente cliente, Model model) {
		
		model.addAttribute("cliente", cliente);
		return "esqueceuSenha";
	}
	
	@GetMapping("/perfil")
	public String showPerfil() {
		
		return "Vitalusus-2h/perfil";
	}
	@GetMapping("/configT")
	public String configuracoes() {
		
		return "configT";
	}
	@GetMapping("/Sobre-nos")
	public String sobrenos() {
		
		return "Sobre-nos";
	}
	@GetMapping("/Estatisticas")
	public String estatisticas() {
		
		return "Estatisticas";
	}
	@GetMapping("/user")
	public String user() {
		
		return "user";
	}
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	@GetMapping("/HomeTreinador")
	public String hometreinador() {
		
		return "HomeTreinador";
	}
	@GetMapping("/publicar")
	public String publicar() {
		
		return "publicar";
	}
}
