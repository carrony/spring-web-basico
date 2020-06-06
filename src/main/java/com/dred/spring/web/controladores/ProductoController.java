package com.dred.spring.web.controladores;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dred.spring.web.modelo.Producto;

@Controller
public class ProductoController {

	
	@GetMapping("/registrarProducto")
	public String formulario(Model model) {
		Producto producto = new Producto();
		model.addAttribute("titulo", "IFCT034PO - Desarrollo de aplicaciones con Java");
		model.addAttribute("mensaje", "Crea un nuevo producto");
		model.addAttribute("producto", producto);
		return "registroProducto";
	}
	
	@PostMapping("/resumenProducto")
	public String procesar(@Valid Producto producto, BindingResult resultado, Model model) {
		
		model.addAttribute("titulo", "IFCT034PO - Desarrollo de aplicaciones con Java");
		model.addAttribute("mensaje", "Resumen del producto creado");
		model.addAttribute("producto", producto);
		
		if (resultado.hasErrors()) {
			
			return "registroProducto";
		}
		return "resumenProducto";
	}
}
