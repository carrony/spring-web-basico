package com.dred.spring.web.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.dred.spring.web.modelo.Producto;

public class ProductoMapper implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto p = new Producto();
		p.setId(rs.getInt("id"));
		p.setNombre(rs.getString("nombre"));
		p.setDescripcion(rs.getString("descripcion"));
		p.setPrecio(rs.getDouble("precio"));
		
		return p;
	}

}
