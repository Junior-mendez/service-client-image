package com.co.pragma.serviceclienteimagen.domain.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.pragma.serviceclienteimagen.domain.exception.ClientImageCreatedException;
import com.co.pragma.serviceclienteimagen.domain.exception.ClientImageNotFoundException;
import com.co.pragma.serviceclienteimagen.domain.exception.ClientImageUpdateException;
import com.co.pragma.serviceclienteimagen.domain.mapper.ClientImageMapper;
import com.co.pragma.serviceclienteimagen.domain.repository.ClientImageRepository;
import com.co.pragma.serviceclienteimagen.helpers.ClientImageHelper;

@ExtendWith(MockitoExtension.class)
class ClientImageServiceImplTest {

	@Mock
	private ClientImageRepository clientImageRepository;
	
	@Mock
	private ClientImageMapper clientImageMapper;
	
	@InjectMocks
	private ClientImageServiceImpl clientImageServiceImpl;

	@Test
	void testCreateClientImage() {
		when(clientImageRepository.create(Mockito.any())).thenReturn(ClientImageHelper.createClientImageEntity());
		when(clientImageMapper.clientImageDomainToClientImageEntity(Mockito.any())).thenReturn(ClientImageHelper.createClientImageEntity());
		when(clientImageMapper.clientImageEntitytoClientImageDomain(Mockito.any())).thenReturn(ClientImageHelper.createClientImage());
		
		assertEquals("DNI76515669",clientImageServiceImpl.create(ClientImageHelper.createClientImage()).getId());
	}
	
	@Test
	void testCreateClientImageException() {
		when(clientImageRepository.create(Mockito.any())).thenReturn(null);
		when(clientImageMapper.clientImageDomainToClientImageEntity(Mockito.any())).thenReturn(ClientImageHelper.createClientImageEntity());
		
		assertThrows(ClientImageCreatedException.class,
				()->{clientImageServiceImpl.create(ClientImageHelper.createClientImage());});
	}
	
	@Test
	void testUpdateClientImage() {
		when(clientImageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(clientImageRepository.update(Mockito.any())).thenReturn(ClientImageHelper.createClientImageEntity());
		when(clientImageMapper.clientImageDomainToClientImageEntity(Mockito.any())).thenReturn(ClientImageHelper.createClientImageEntity());
		when(clientImageMapper.clientImageEntitytoClientImageDomain(Mockito.any())).thenReturn(ClientImageHelper.createClientImage());
		
		assertEquals("DNI76515669",clientImageServiceImpl.update(ClientImageHelper.createClientImage()).getId());
	}
	
	@Test
	void testUpdateClientImageException() {
		when(clientImageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(clientImageRepository.update(Mockito.any())).thenReturn(null);
		when(clientImageMapper.clientImageDomainToClientImageEntity(Mockito.any())).thenReturn(ClientImageHelper.createClientImageEntity());
		
		assertThrows(ClientImageUpdateException.class,
				()->{clientImageServiceImpl.update(ClientImageHelper.createClientImage());});
	}
	@Test
	void testUpdateClientImageNotFoundException() {
		when(clientImageRepository.existsImage(Mockito.any())).thenReturn(false);
		
		assertThrows(ClientImageNotFoundException.class,
				()->{clientImageServiceImpl.update(ClientImageHelper.createClientImage());});
	}
	
	@Test
	void testGetClientImage() {
		when(clientImageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(clientImageRepository.getImage(Mockito.anyString())).thenReturn(Optional.of(ClientImageHelper.createClientImageEntity()));
		when(clientImageMapper.clientImageEntitytoClientImageDomain(Mockito.any())).thenReturn(ClientImageHelper.createClientImage());
		
		assertEquals("DNI76515669",clientImageServiceImpl.getImage("DNI76515669").getId());
	}
	@Test
	void testGetClientImageNotFoundException() {
		when(clientImageRepository.existsImage(Mockito.any())).thenReturn(false);
		
		assertThrows(ClientImageNotFoundException.class,
				()->{clientImageServiceImpl.getImage("DNI76515669");});
	}
	@Test
	void testGetClientImageException() {
		when(clientImageRepository.existsImage(Mockito.any())).thenReturn(true);
		when(clientImageRepository.getImage(Mockito.anyString())).thenReturn(Optional.of(ClientImageHelper.createClientImageEntity()));
		when(clientImageMapper.clientImageEntitytoClientImageDomain(Mockito.any())).thenReturn(null);
		assertThrows(ClientImageNotFoundException.class,
				()->{clientImageServiceImpl.getImage("DNI76515669");});
	}

}
