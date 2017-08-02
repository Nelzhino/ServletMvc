package co.com.pruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PruebaServlet
 */

@WebServlet("/PruebaServlet")
public class PruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public PruebaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		try{
			connection = miPool.getConnection();			
			statement= connection.createStatement();
			resultSet = statement.executeQuery("select * from producto");
			
			while(resultSet.next()){
				String nombre = resultSet.getString("nombre");
				
				salida.println(nombre);
			}
		}catch(Exception e){
			System.out.println(String.format("Error de conexion: %s", e.getMessage()));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
