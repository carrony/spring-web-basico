package com.dred.spring.web.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/editarProducto")
	public String editarform(@RequestParam int id, Model model) {
		Producto producto = new Producto();
		model.addAttribute("mensaje", "Editar un producto");
		if (id!=0) {
			producto=productoDAO.getProducto(id);
			model.addAttribute("producto", producto);
		} else {
			model.addAttribute("producto", producto);
			return "redirect:mostar_productos";
		}
		return "editarProducto";
	}
	
	@PostMapping("/modificarProducto")
	public String editar(@Valid Producto producto, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			model.addAttribute("producto", producto);
			return "editarProducto";
		}
		productoDAO.editarProducto(producto);
		return "redirect:mostrar_productos";
	}
	
	@GetMapping("/eliminarProducto")
	public String eliminar(@RequestParam int id, Model model) {
		if (id!=0) {
			productoDAO.eliminarProducto(id);
		} 
		return "redirect:mostrar_productos";
	}
}
