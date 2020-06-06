package com.dred.spring.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dred.spring.web.modelo.Producto;

@Controller
public class ProductoController {

	
	@GetMapping("/registrarProducto")
	public String formulario(Model model) {
		model.addAttribute("titulo", "IFCT034PO - Desarrollo de aplicaciones con Java");
		model.addAttribute("mensaje", "Crea un nuevo producto");
		return "registroProducto";
	}
	
	@PostMapping("/resumenProducto")
	public String procesar(Producto producto, Model model) {
		model.addAttribute("titulo", "IFCT034PO - Desarrollo de aplicaciones con Java");
		model.addAttribute("mensaje", "Resumen del producto creado");
		model.addAttribute("producto", producto);
		System.out.println(producto);
		return "resumenProducto";
	}
}
