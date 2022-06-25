package com.co.pragma.serviceclienteimagen.infraestructure.mongo.repository.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.pragma.serviceclienteimagen.domain.repository.ClientImageRepository;
import com.co.pragma.serviceclienteimagen.infraestructure.mongo.entity.ClientImageEntity;
import com.co.pragma.serviceclienteimagen.infraestructure.mongo.repository.MongoDataRepository;

@Component
public class MongoDBDataRepositoryImpl implements ClientImageRepository {
	
	
	@Autowired
	private MongoDataRepository mongoDataRepository;

	@Override
	public ClientImageEntity create(ClientImageEntity clientImage) {
		return mongoDataRepository.insert(clientImage);
	}

	@Override
	public Boolean existsImage(String id) {
		return mongoDataRepository.existsById(id);
	}

	@Override
	public ClientImageEntity update(ClientImageEntity clientImage) {
		return mongoDataRepository.save(clientImage);
	}

	@Override
	public Optional<ClientImageEntity> getImage(String id) {
		return mongoDataRepository.findById(id);
	}

}
