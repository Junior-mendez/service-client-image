package com.co.pragma.serviceclienteimagen.domain.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.pragma.serviceclienteimagen.domain.clientimage.ClientImage;
import com.co.pragma.serviceclienteimagen.domain.exception.ClientImageCreatedException;
import com.co.pragma.serviceclienteimagen.domain.exception.ClientImageNotFoundException;
import com.co.pragma.serviceclienteimagen.domain.exception.ClientImageUpdateException;
import com.co.pragma.serviceclienteimagen.domain.mapper.ClientImageMapper;
import com.co.pragma.serviceclienteimagen.domain.repository.ClientImageRepository;
import com.co.pragma.serviceclienteimagen.domain.service.ClientImageService;

@Service
public class ClientImageServiceImpl implements ClientImageService {
	
	@Autowired
	private ClientImageRepository clientImageRepository;
	
	@Autowired
	private ClientImageMapper clientImageMapper;

	@Override
	public ClientImage create(ClientImage client) {
		return Optional.ofNullable(clientImageRepository
				.create(clientImageMapper.clientImageDomainToClientImageEntity(client)))
				.map(clientImageMapper::clientImageEntitytoClientImageDomain)
				.orElseThrow(()->new ClientImageCreatedException(client));
	}

	@Override
	public ClientImage update(ClientImage client) {
		if(Boolean.FALSE.equals(clientImageRepository.existsImage(client.getId()))) {
			throw new ClientImageNotFoundException(client.getId());
		}
		return Optional.ofNullable(clientImageRepository
				.update(clientImageMapper.clientImageDomainToClientImageEntity(client)))
				.map(clientImageMapper::clientImageEntitytoClientImageDomain)
				.orElseThrow(()->new ClientImageUpdateException(client.getId()));
	}

	@Override
	public ClientImage getImage(String id) {
		if(Boolean.FALSE.equals(clientImageRepository.existsImage(id))) {
			throw new ClientImageNotFoundException(id);
		}

		return clientImageRepository.getImage(id)
				.map(clientImageMapper::clientImageEntitytoClientImageDomain)
				.orElseThrow(()->new ClientImageNotFoundException(id));
	}

}
