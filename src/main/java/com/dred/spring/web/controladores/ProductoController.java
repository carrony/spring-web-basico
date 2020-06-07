package com.dred.spring.web.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dred.spring.web.modelo.Producto;
import com.dred.spring.web.modelo.dao.ProductoDAO;

@Controller
public class ProductoController {

	@Autowired
	@Qualifier("productoDAOJDBC")
	private ProductoDAO productoDAO;
	
	@GetMapping("/registrarProducto")
	public String formulario(Model model) {
		Producto producto = new Producto();
		model.addAttribute("mensaje", "Crea un nuevo producto");
		model.addAttribute("producto", producto);
		return "registroProducto";
	}
	
	@PostMapping("/resumenProducto")
	public String procesar(@Valid Producto producto, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			model.addAttribute("producto", producto);
			return "registroProducto";
		}
		productoDAO.insertarProducto(producto);
		return "redirect:mostrar_productos";
	}
	
	@GetMapping("/mostrar_productos")
	public String mostrar_productos(Model model) {
		model.addAttribute("mensaje", "Listado de productos");
		model.addAttribute("listaProductos", productoDAO.getListaProductos());
		return "listarProductos";
	}
}
