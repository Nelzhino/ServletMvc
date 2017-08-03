package co.com.pruebas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PruebaServlet
 */

@WebServlet("/Producto")
public class ControladorProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/Productos")
	private DataSource miPool;
	private Conexion conexion;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorProductoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			conexion = new Conexion(miPool);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer instruccion = 0;
		if (request.getParameter("instruccion") != null) {
			instruccion = Integer.parseInt(request.getParameter("instruccion"));
		}

		switch (instruccion) {
		case 0:
			listarProductos(request, response);
			break;
		case 1:
			agregarProductos(request, response);
			break;
		case 2:
			try {
				cargarProductos(request, response);
			} catch (Exception e) {
				e.getMessage();
			}
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listadoProductos", conexion.getProductos());
			RequestDispatcher vista = request.getRequestDispatcher("/index.jsp");
			vista.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {

		Producto producto = new Producto();
		producto.setDescripcion(request.getParameter("descripcion"));
		producto.setNombre(request.getParameter("nombre"));
		producto.setValor(Float.parseFloat(request.getParameter("valor")));

		conexion.crearProducto(producto);

		this.listarProductos(request, response);

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Producto producto = conexion.cargarProducto(Integer.parseInt(request.getParameter("codigo")));
		
		request.setAttribute("dataProducto", producto);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/load.jsp");
		requestDispatcher.forward(request, response);

	}

}
