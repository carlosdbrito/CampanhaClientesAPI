package com.almeidatecnologia.CampanhaClientes.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.almeidatecnologia.CampanhaClientes.model.Beneficio;
import com.almeidatecnologia.CampanhaClientes.model.Cliente;

public interface ClienteServiceInterface {
	
	Cliente salvarCliente(Cliente cliente);	
	Optional<Cliente> obterClientePorId(Long id);	
	List<Cliente> obterTodosClientes();	
	Cliente atualizarCliente(Cliente cliente);	
	void deletarCliente(Long id);	
}
