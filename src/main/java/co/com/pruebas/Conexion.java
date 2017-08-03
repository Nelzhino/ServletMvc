package co.com.pruebas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from producto");

			while (resultSet.next()) {
				Producto producto = new Producto();
				producto.setCodigo(resultSet.getInt("codigo"));
				producto.setNombre(resultSet.getString("nombre"));
				producto.setDescripcion(resultSet.getString("descripcion"));
				producto.setValor(resultSet.getFloat("precio"));

				productos.add(producto);
			}
		} catch (Exception e) {
			System.out.println(String.format("Error de conexion: %s", e.getMessage()));
		}

		return productos;
	}

	public void crearProducto(Producto producto) {
		try {
			String sql = "INSERT INTO producto(nombre,descripcion,precio)VALUES(?,?,?)";
			Connection conexion = dataSource.getConnection();
			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setString(2, producto.getDescripcion());
			preparedStatement.setFloat(3, producto.getValor());

			if (preparedStatement.executeUpdate() <= 0) {
				throw new SQLException("No se inserto ninguno producto");
			}

		} catch (SQLException e) {
			System.out.println(String.format("Error de conexion: %s", e.getMessage()));
		}

	}

	public Producto cargarProducto(Integer codigo) {
		Producto producto = new Producto();
		String sql = "SELECT * FROM producto WHERE codigo = ?";
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, codigo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				producto.setCodigo(resultSet.getInt("codigo"));
				producto.setNombre(resultSet.getString("nombre"));
				producto.setDescripcion(resultSet.getString("descripcion"));
				producto.setValor(resultSet.getFloat("precio"));
			}
		} catch (SQLException e) {
			System.out.println(String.format("Error en la ejecuccion del script: %s", e.getMessage()));
		}

		return producto;
	}
}
