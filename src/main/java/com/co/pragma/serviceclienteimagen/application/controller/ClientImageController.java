package com.co.pragma.serviceclienteimagen.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.pragma.serviceclienteimagen.application.request.ClientImageRequest;
import com.co.pragma.serviceclienteimagen.domain.clientimage.ClientImage;
import com.co.pragma.serviceclienteimagen.domain.service.ClientImageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/image")
public class ClientImageController {
	
	@Autowired
	private ClientImageService clienteImagenService;
	
	@PostMapping(value = "/create"
			,consumes  = {MediaType.APPLICATION_JSON_VALUE}
			,produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(
		      value = "Insert image of client",
		      nickname = "Insert image of client",
		      response = ClientImage.class)
	@ApiResponses(
		      value = {
		        @ApiResponse(code = 200, message = "Success"),
		        @ApiResponse(code = 400, message = "Bad Request"),
		        @ApiResponse(code = 403, message = "Forbidden"),
		        @ApiResponse(code = 404, message = "Not Found"),
		        @ApiResponse(code = 500, message = "Failure")
		      })
	public ResponseEntity<ClientImage> create(@RequestBody ClientImageRequest clientImage) {
		
	     return new ResponseEntity<>(clienteImagenService.create(ClientImage.builder()
	    		 .id(clientImage.getId()).image(clientImage.getImage()).build()),HttpStatus.OK);
	}
	
	@PostMapping(value = "/update"
			,consumes  = {MediaType.APPLICATION_JSON_VALUE}
			,produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(
		      value = "Update image of client",
		      nickname = "Update image of client",
		      response = ClientImage.class)
	@ApiResponses(
		      value = {
		        @ApiResponse(code = 200, message = "Success"),
		        @ApiResponse(code = 400, message = "Bad Request"),
		        @ApiResponse(code = 403, message = "Forbidden"),
		        @ApiResponse(code = 404, message = "Not Found"),
		        @ApiResponse(code = 500, message = "Failure")
		      })
	public ResponseEntity<ClientImage> update(@RequestBody ClientImageRequest clientImage) {
		 
	     return new ResponseEntity<>(clienteImagenService.update(ClientImage.builder()
	    		 .id(clientImage.getId()).image(clientImage.getImage()).build()),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}"
				,produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(
		      value = "Get image of client",
		      nickname = "Get image of client",
		      response = ClientImage.class)
	@ApiResponses(
		      value = {
		        @ApiResponse(code = 200, message = "Success"),
		        @ApiResponse(code = 400, message = "Bad Request"),
		        @ApiResponse(code = 403, message = "Forbidden"),
		        @ApiResponse(code = 404, message = "Not Found"),
		        @ApiResponse(code = 500, message = "Failure")
		      })
	public ResponseEntity<ClientImage> getImage(@PathVariable(name = "id") String id)  {
		 
	     return new ResponseEntity<>(clienteImagenService.getImage(id),HttpStatus.OK);
	}

}
