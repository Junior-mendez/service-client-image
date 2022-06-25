package com.co.pragma.serviceclienteimagen.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientImageRequest {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("image")
	private String image;

}
