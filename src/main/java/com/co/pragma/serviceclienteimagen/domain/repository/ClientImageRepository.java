package com.co.pragma.serviceclienteimagen.domain.repository;

import java.util.Optional;

import com.co.pragma.serviceclienteimagen.infraestructure.mongo.entity.ClientImageEntity;

public interface ClientImageRepository {
	
	ClientImageEntity create(ClientImageEntity clientImage);
	
	Boolean existsImage(String id);
	
	ClientImageEntity update(ClientImageEntity clientImage);
	
	Optional<ClientImageEntity> getImage(String id);

}
