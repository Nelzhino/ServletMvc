package co.com.pruebas;

public class Producto {

	private int codigo;
	private String nombre;
	private String descripcion;
	private float valor;
	
	public Producto(int codigo, String nombre, String descripcion, float valor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String descripcion, float valor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", valor=" + valor + "]";
	}
	
	
	
}
