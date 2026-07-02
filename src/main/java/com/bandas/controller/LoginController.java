package com.bandas.controller;

import com.bandas.service.AutenticacionService;
import com.bandas.util.Alert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bandas.dto.AutenticacionFilter;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {
	
	private final AutenticacionService autenticacionService;
	
	@GetMapping("iniciar-sesion")
	public String iniciarSesion(@ModelAttribute AutenticacionFilter filter, Model model, RedirectAttributes flash, HttpSession httpSession) {
		
		var usuario = autenticacionService.atenticathe(filter);
		
		if (usuario == null) {
			var mensaje = Alert.sweetAlertError("Cuenta y/o clave invalido");
			model.addAttribute("alert", mensaje);
			model.addAttribute("filter", filter);
			
			return "login";
		}
		
		if (!usuario.getActivo()) {
			var mensaje = Alert.sweetAlertError("La cuenta se encuentra inactiva");
			model.addAttribute("alert", mensaje);
			model.addAttribute("filter", filter);
			
			return "login";
			
		}
		//guardar datos necesarios para la sesion
		httpSession.setAttribute("idUsuario", usuario.getIdUsuario());
		httpSession.setAttribute("fullName", usuario.getFullName());
		httpSession.setAttribute("idTipo", usuario.getTipo());
		
		//maximo tiempo de inactividad 5min
		httpSession.setMaxInactiveInterval(300);
		
		String alert = Alert.sweetImageUrl("Bienvenido rockero", usuario.getFullName(), "/imagenes/ironMaiden.gif");
		flash.addFlashAttribute("alert", alert);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("cerrar-sesion")
	public String cerrarSesion(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
}
