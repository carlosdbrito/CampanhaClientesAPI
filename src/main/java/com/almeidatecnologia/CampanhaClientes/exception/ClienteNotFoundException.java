package com.almeidatecnologia.CampanhaClientes.exception;

public class ClienteNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ClienteNotFoundException(Object id) {
		super("Cliente nao encontrado. Id do Cliente : " + id.toString());
	}
}