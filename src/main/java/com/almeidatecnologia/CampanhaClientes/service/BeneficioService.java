package com.almeidatecnologia.CampanhaClientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almeidatecnologia.CampanhaClientes.exception.BeneficioNotFoundException;
import com.almeidatecnologia.CampanhaClientes.exception.ClienteNotFoundException;
import com.almeidatecnologia.CampanhaClientes.model.Beneficio;
import com.almeidatecnologia.CampanhaClientes.model.Cliente;
import com.almeidatecnologia.CampanhaClientes.repository.BeneficioRepository;
import com.almeidatecnologia.CampanhaClientes.service.interfaces.BeneficioServiceInterface;

@Service
public class BeneficioService implements BeneficioServiceInterface {
    
	private BeneficioRepository beneficioRepository;
    
	@Autowired
	public BeneficioService(BeneficioRepository beneficioRepository) {
		this.beneficioRepository = beneficioRepository;
	}
	
	@Override
	public Beneficio salvarBeneficio(Beneficio beneficio) {
		return beneficioRepository.save(beneficio);
	}
	

	@Override
	public Optional<Beneficio> obterBeneficioPorId(Long id) throws BeneficioNotFoundException {
		return beneficioRepository.findById(id);
	}

	@Override
	public Beneficio atualizarBeneficio(Beneficio beneficio) throws BeneficioNotFoundException {
		Optional<Beneficio> findBeneficio = beneficioRepository.findById(beneficio.getId());
				
		if(findBeneficio.isPresent()) {
			Beneficio updateBeneficio = findBeneficio.get();
			updateBeneficio.setNome(beneficio.getNome());
			updateBeneficio.setDescricao(beneficio.getDescricao());
			updateBeneficio.setNome(beneficio.getNome());
			updateBeneficio.setDataInicio(beneficio.getDataInicio());
			updateBeneficio.setDataFim(beneficio.getDataFim());
			
			
			return beneficioRepository.save(updateBeneficio);
		}
		return beneficio;		
	}

	@Override
	public void deletarBeneficio(Long id) throws BeneficioNotFoundException {
		beneficioRepository.deleteById(id);		
	}	    
}