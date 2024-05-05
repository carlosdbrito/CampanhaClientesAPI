package com.almeidatecnologia.CampanhaClientes.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.almeidatecnologia.CampanhaClientes.exception.BeneficioNotFoundException;
import com.almeidatecnologia.CampanhaClientes.exception.ClienteNotFoundException;
import com.almeidatecnologia.CampanhaClientes.exception.DatabaseException;
import com.almeidatecnologia.CampanhaClientes.model.Beneficio;
import com.almeidatecnologia.CampanhaClientes.model.Cliente;
import com.almeidatecnologia.CampanhaClientes.repository.ClienteRepository;
import com.almeidatecnologia.CampanhaClientes.service.interfaces.ClienteServiceInterface;

@Service
public class ClienteService implements ClienteServiceInterface {

    private ClienteRepository clienteRepository;

    @Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> obterClientePorId(Long id) throws ClienteNotFoundException {
		return clienteRepository.findById(id);	
	}

	@Override
	public List<Cliente> obterTodosClientes() {
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente atualizarCliente(Cliente cliente) throws ClienteNotFoundException {		
		Optional<Cliente> findCliente = clienteRepository.findById(cliente.getId());
				
		if(findCliente.isPresent()) {
			Cliente updateCliente = findCliente.get();
			updateCliente.setNome(cliente.getNome());
			updateCliente.setAgencia(cliente.getAgencia());
			updateCliente.setConta(cliente.getConta());
			updateCliente.setTipoConta(cliente.getTipoConta());
			updateCliente.setScore(cliente.getScore());
			return clienteRepository.save(updateCliente);
		}
		return cliente;
	}
	
	@Override
	public void deletarCliente(Long id) {
		try {
				clienteRepository.deleteById(id);		
			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
	}
		
}

