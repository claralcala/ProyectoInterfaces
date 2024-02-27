package modelo;

public class Producto {
	
	private int product_id;
	
	private String nombre;
	
	private String descripcion;
	
	private int stock;
	
	private double precio;
	
	private String imagen;
	
	private int cantidad;
	
	
	
	public Producto(int product_id) {
		super();
		this.product_id = product_id;
	public Producto(int product_id, String nombre, double precio) {
		super();
		this.product_id = product_id;
		this.nombre = nombre;
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Producto() {
		
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Override
	public String toString() {
		return "Producto [product_id=" + product_id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock="
				+ stock + ", precio=" + precio + ", imagen=" + imagen + "]";
	}
}

