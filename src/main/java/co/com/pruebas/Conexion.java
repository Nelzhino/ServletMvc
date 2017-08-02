package co.com.pruebas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class Conexion {

	private DataSource dataSource;

	public Conexion(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<Producto> getProductos() throws Exception {
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		List<Producto> productos = new ArrayList<Producto>();
		try{
			connection = dataSource.getConnection();			
			statement= connection.createStatement();
			resultSet = statement.executeQuery("select * from producto");
			
			while(resultSet.next()){
				Producto producto = new Producto();
				producto.setCodigo(resultSet.getInt("codigo"));
				producto.setNombre(resultSet.getString("nombre"));
				producto.setDescripcion(resultSet.getString("descripcion"));
				producto.setValor(resultSet.getFloat("precio"));
				
				productos.add(producto);
			}
		}catch(Exception e){
			System.out.println(String.format("Error de conexion: %s", e.getMessage()));
		}
		
		return productos;
	}
	
	
}
