package com.dred.spring.web.modelo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Producto implements Serializable{

	private static final long serialVersionUID = -6064234116982533238L;
	private int id;
	@NotEmpty
	private String nombre;
	@Size(max=30)
	private String descripcion;
	@Positive
	@NotNull
	private double precio;
	private String rutaImagen;
	
	public Producto() {
	}
	public Producto(int id, String nombre, String descripcion, double precio) {
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
}