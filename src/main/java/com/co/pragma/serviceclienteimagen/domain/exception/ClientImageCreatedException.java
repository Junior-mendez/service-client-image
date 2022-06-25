package com.co.pragma.serviceclienteimagen.domain.exception;

import com.co.pragma.serviceclienteimagen.domain.clientimage.ClientImage;

public class ClientImageCreatedException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8515033326580079609L;
	
	public ClientImageCreatedException (ClientImage client) {
		super("Cliente no fue creado".concat(client.toString()));
	}

}
