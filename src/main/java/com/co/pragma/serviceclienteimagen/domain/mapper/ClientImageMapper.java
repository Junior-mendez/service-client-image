package com.co.pragma.serviceclienteimagen.domain.mapper;


import org.mapstruct.Mapper;

import com.co.pragma.serviceclienteimagen.domain.clientimage.ClientImage;
import com.co.pragma.serviceclienteimagen.infraestructure.mongo.entity.ClientImageEntity;

@Mapper(componentModel = "spring")
public interface ClientImageMapper {
	
	
	ClientImageEntity clientImageDomainToClientImageEntity(ClientImage clientImage);
	
	ClientImage clientImageEntitytoClientImageDomain(ClientImageEntity clientImageEntity);

}
