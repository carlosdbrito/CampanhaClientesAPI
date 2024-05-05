package com.almeidatecnologia.CampanhaClientes.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.almeidatecnologia.CampanhaClientes.model.Beneficio;

public interface BeneficioServiceInterface {
	
	Beneficio salvarBeneficio(Beneficio beneficio);	
	Optional<Beneficio> obterBeneficioPorId(Long id);
	Beneficio atualizarBeneficio(Beneficio beneficio);
	void deletarBeneficio(Long id);	
}
