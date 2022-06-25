package com.co.pragma.serviceclienteimagen.domain.exception;

public class ClientImageUpdateException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1486639806995385785L;
	
	public ClientImageUpdateException(String id) {
		super ("Imagen de cliente con id: ".concat(id).concat(" no fue actualizado"));
	}

}
