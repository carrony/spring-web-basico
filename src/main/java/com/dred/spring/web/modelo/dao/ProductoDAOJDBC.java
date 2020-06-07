package com.dred.spring.web.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dred.spring.web.modelo.Producto;

@Repository("productoDAOJDBC")
public class ProductoDAOJDBC implements ProductoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	

	@Override
	public List<Producto> getListaProductos() {
		List<Producto> listaProductos = jdbcTemplate.query(
				"select * from productos", new ProductoMapper());
		return listaProductos;
	}

	@Override
	public Producto getProducto(int id) {
		Producto p = null;
		p=jdbcTemplate.queryForObject(
				"select * from productos where id= ?", 
				new Object [] {id},
				new ProductoMapper());
		return p;
	}

	@Override
	public void insertarProducto(Producto p) {
		jdbcTemplate.update(
			 "insert into productos(nombre,descripcion,precio) values(?,?,?)",
			 p.getNombre(),p.getDescripcion(),p.getPrecio());
	}

	@Override
	public void eliminarProducto(int id) {
		jdbcTemplate.update("delete form productos where id=?",id);
	}

	@Override
	public void editarProducto(Producto p) {
		jdbcTemplate.update(
			"update productos set nombre=?, descripcion=?, precio=? where id=?",
			p.getNombre(),p.getDescripcion(),p.getPrecio(),p.getId());
	}

}
