package com.co.pragma.serviceclienteimagen.domain.clientimage;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientImage {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("image")
	private String image;

}
