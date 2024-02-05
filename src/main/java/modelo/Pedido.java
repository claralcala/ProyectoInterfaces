package modelo;

import java.util.Date;

public class Pedido {
	
	private int pedido_id;
	
	private int user_id;
	
	private Date fecha;
	
	
	public Pedido() {
		
	}


	public int getPedido_id() {
		return pedido_id;
	}


	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Pedido [pedido_id=" + pedido_id + ", user_id=" + user_id + ", fecha=" + fecha + "]";
	}
	
	
	
	
	

}
