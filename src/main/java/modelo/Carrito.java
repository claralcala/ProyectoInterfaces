package modelo;

public class Carrito {
	
	private int carrito_id;
	
	private int user_id;
	
	private int product_id;
	
	private int cantidad;
	
	
	public Carrito () {
		
	}


	public int getCarrito_id() {
		return carrito_id;
	}


	public void setCarrito_id(int carrito_id) {
		this.carrito_id = carrito_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Carrito [carrito_id=" + carrito_id + ", user_id=" + user_id + ", product_id=" + product_id
				+ ", cantidad=" + cantidad + "]";
	}
	
	

}
