package com.almeidatecnologia.CampanhaClientes.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.almeidatecnologia.CampanhaClientes.model.Beneficio;

public interface BeneficioRepository  extends JpaRepository<Beneficio, Long> {
	
	 Optional<Beneficio> findByClienteId(Long clienteId);

}
