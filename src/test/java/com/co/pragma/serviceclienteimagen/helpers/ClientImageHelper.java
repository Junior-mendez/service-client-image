package com.co.pragma.serviceclienteimagen.helpers;

import com.co.pragma.serviceclienteimagen.application.request.ClientImageRequest;
import com.co.pragma.serviceclienteimagen.domain.clientimage.ClientImage;
import com.co.pragma.serviceclienteimagen.infraestructure.mongo.entity.ClientImageEntity;

public class ClientImageHelper {
	
	public static ClientImageRequest createClientImageRequest() {
		return new ClientImageRequest("DNI76515669","DSDSFDSFSDF");
	}
	public static ClientImage createClientImage() {
		return new ClientImage("DNI76515669","DSDSFDSFSDF");
	}
	
	public static ClientImageEntity createClientImageEntity() {
		return new ClientImageEntity("DNI76515669","DSDSFDSFSDF");
	}
}
