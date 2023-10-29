package com.itb.tcc.Vitalusus.h.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.tcc.Services.ClienteService;
import com.itb.tcc.Vitalusus.h.model.Cliente;
import com.itb.tcc.Vitalusus.h.repository.ClienteRepository;

// http://localhost:8080/Vitalusus-2h/Clientes/listaClientes

@Controller
@RequestMapping("/Vitalusus-2h/Clientes")
public class ClienteController {
	List<Cliente> listaDeClientes = new ArrayList<Cliente>(); // Variável Array
	private ClienteRepository clienteRepository;
	private ClienteService clienteService;
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
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
		Cliente clientedb = clienteRepository.save(cliente);
		return "redirect:/Vitalusus-2h/Clientes/clienteSucesso";
	} 
	
	// carregar formulário login
	
	@GetMapping("/login")
	public String showFormLogin(Cliente cliente, Model model){
		
		model.addAttribute("cliente", cliente);
		return "login";
	}
	
	@PostMapping("/login")
	public String efetuarLogin(@ModelAttribute Cliente cliente){ 
		String page = "redirect:/Vitalusus-2h/Clientes/login";
		
		Cliente clienteDb = clienteRepository.findByLogin(cliente.getEmail(), cliente.getSenha());
		if (clienteDb !=null && cliente.getSenha().equals(clienteDb.getSenha())&&cliente.getEmail().equals(clienteDb.getEmail())){
			page = "redirect:/Vitalusus-2h/Clientes/HomeTreinador";
		}
		
		return page;
	}

	
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
	public String configuracoes(Cliente cliente) {
		
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
	public String hometreinador(Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		
		return "HomeTreinador";
	}
	@GetMapping("/publicar")
	public String publicar() {
		
		return "publicar";
	}
	@GetMapping("/bibliotecaVideos")
	public String bibliotecaVideos() {
		
		return "bibliotecaVideos";
	}
	@GetMapping("/editarSuaConta")
	public String editarConta(Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		return "editarSuaConta";
	}
	@GetMapping("/cliejtesucessoEditar")
	public String putEditar(Cliente cliente, Model model) {
		return "clientesucessoEditar";
	}
	@PutMapping("/clientesucessoEditar")
	public String editar(@ModelAttribute Cliente cliente) {
		if(cliente.getId()>0) clienteRepository.save(cliente);
		return "redirect:/Vitalusus-2h/Clientes/user";
	}
	
	@DeleteMapping("/configT")
	public String deletar(@ModelAttribute Cliente cliente) {
		Cliente clienteDb = clienteRepository.findByLogin(cliente.getEmail(),cliente.getSenha());
		clienteRepository.deleteById(clienteDb.getId());
		return "redirect:/Vitalusus-2h/Clientes/index";
	}
}
