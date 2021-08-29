package br.com.luciano.InventoryControl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@GetMapping("")
	public String getUsuario() {
		
		return "ksdjfdhsksjhflsdhfkldsdhsk";
		
		
	}

}
