package com.dred.spring.web.modelo.dao;

import java.util.List;
import com.dred.spring.web.modelo.Producto;

public interface ProductoDAO {
	public List<Producto> getListaProductos();
	public Producto getProducto(int id);
	public void insertarProducto(Producto p);
	public void eliminarProducto(int id);
	public void editarProducto(Producto p);
}
