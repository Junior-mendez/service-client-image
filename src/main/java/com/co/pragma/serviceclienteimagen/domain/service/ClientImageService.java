package com.co.pragma.serviceclienteimagen.domain.service;

import com.co.pragma.serviceclienteimagen.domain.clientimage.ClientImage;

public interface ClientImageService {
	
	ClientImage create(ClientImage cliente);
	
	ClientImage update(ClientImage cliente) ;
	
	ClientImage getImage(String id);

}
