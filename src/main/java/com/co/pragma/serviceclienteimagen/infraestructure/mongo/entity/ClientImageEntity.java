package com.co.pragma.serviceclienteimagen.infraestructure.mongo.entity;


import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "prueba")
public class ClientImageEntity {
	
	@Id
	private String id;
		
	@Field("image")
	private String image;

}
