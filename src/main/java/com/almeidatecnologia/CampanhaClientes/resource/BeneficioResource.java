package com.almeidatecnologia.CampanhaClientes.resource;

import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;

import com.almeidatecnologia.CampanhaClientes.model.Beneficio;
import com.almeidatecnologia.CampanhaClientes.service.BeneficioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@Tag(name="Beneficio")
@RequestMapping("/api/beneficio")
public class BeneficioResource {

    private BeneficioService beneficioService;

    @Autowired
    public BeneficioResource(BeneficioService beneficioService) {
        this.beneficioService = beneficioService;
    }
    
    @Operation(summary = "Retorna os dados de um Beneficio por ID.")
	@GetMapping("/{id}")
	public ResponseEntity<Optional< Beneficio>> obterBeneficioPorId(@PathVariable Long id){
		Optional< Beneficio> objBeneficio =  beneficioService.obterBeneficioPorId(id);
		if(objBeneficio == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(objBeneficio);
	}
		
    @Operation(summary = "Remove um Beneficio por ID).")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarBeneficio(@PathVariable Long id){
		 beneficioService.deletarBeneficio(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
