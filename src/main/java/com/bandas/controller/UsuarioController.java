package com.bandas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bandas.dto.UsuarioFilter;
import com.bandas.model.Usuario;
import com.bandas.service.TipoService;
import com.bandas.service.UsuarioService;
import com.bandas.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("usuario")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	private final TipoService tiposervice;


	
	@GetMapping("listado")
	public String listado(@ModelAttribute UsuarioFilter filter, Model model) {
		model.addAttribute("lstUsuarios", usuarioService.search(filter));
		model.addAttribute("tipos", tiposervice.getAll());
		model.addAttribute("filter", filter);
		
		return "usuario/listado";	
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("tipos", tiposervice.getAll());
		model.addAttribute("usuario", new Usuario());
		
		return "usuario/nuevo";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute Usuario usuario, Model model, RedirectAttributes flash) {
		
		var response = usuarioService.create(usuario);
		
		if (!response.success()) {
			model.addAttribute("tipos", tiposervice.getAll());
			model.addAttribute("usuario", usuario);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			
			return "usuario/nuevo";
		}
		
		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast",toast);
		
		return "redirect:/usuario/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("tipos", tiposervice.getAll());
		model.addAttribute("usuario", usuarioService.getOne(id));
		
		return "usuario/edicion";
	}
	
	@PostMapping("guardar")
	public String guardar(@ModelAttribute Usuario usuario, Model model, RedirectAttributes flash) {
		
		var response = usuarioService.update(usuario);
		
		if (!response.success()) {
			model.addAttribute("tipos", tiposervice.getAll());
			model.addAttribute("usuario", usuario);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			
			return "usuario/edicion";
		}
		
		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast", toast);
		
		return "redirect:/usuario/listado";
	}
	
	@PostMapping("cambiar-estado")
	public String cambiarEstado(@RequestParam Integer id, RedirectAttributes flash) {
		
		var response = usuarioService.changeActive(id);
		
		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast",toast);
		
		return "redirect:/usuario/listado";
		
		
	}
	
	
	
}
