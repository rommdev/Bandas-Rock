package com.bandas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bandas.dto.UsuarioFilter;
import com.bandas.service.UsuarioService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;

	
	//@GetMapping("listado")
	//public String listado(@ModelAttribute UsuarioFilter filter, Model model) {
		//model.addAttribute("lstUsuarios", usuarioService.search(filter));
		
	//}
}
