package com.itb.tcc.Services;

import org.springframework.stereotype.Service;

import com.itb.tcc.Vitalusus.h.model.Cliente;
import com.itb.tcc.Vitalusus.h.repository.ClienteRepository;

@Service

public class ClienteService {
	private ClienteRepository clienteRepository;
	public Cliente findById(long id) {
		return this.clienteRepository.findById(id).get();
	}
	public void deletar(Long id) {
		this.clienteRepository.deleteById(id);
	}

}
