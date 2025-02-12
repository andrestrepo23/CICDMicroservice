package com.bancolombia.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.app.entities.Client;
import com.bancolombia.app.service.IService;

@RestController//work json
@RequestMapping("/Client")//Me ayuda a que pueda indicar la ruta que usan los clientes para ingresar al Ms: eje: http://ip:port/Client
public class MicroController {

	@Autowired
	private IService service;
	
	@PostMapping //Para indicar que es un metodo de tipo post
	public ResponseEntity<String> insert (@RequestBody Client cl){ //Para indicar que el cliente va en el cuerpo del request
		if(service.insert(cl)) {
			return new ResponseEntity<String>("Insertado",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("error",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> selectAll(){
		
		return new ResponseEntity<List<Client>>(service.selectAll(),HttpStatus.OK);//la DB entrega la info al DAO y este al servicio y a su vez al controller
	}
	
}
