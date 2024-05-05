package com.almeidatecnologia.CampanhaClientes.exception;

public class BeneficioNotFoundException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public BeneficioNotFoundException(Object id) {
		super("Befefício nao encontrado. Id do Benefício : " + id.toString());
	}
}
