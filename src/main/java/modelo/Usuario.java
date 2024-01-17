package modelo;

public class Usuario {
	
	private int user_id;
	
	private String username;
	
	private String contrasena;
	
	private String nombre;
	
	private String apellidos;
	
	private String correo_electronico;
	
	private String telefono;
	
	private String direccion;
	
	
	public Usuario() {
		
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo_electronico() {
		return correo_electronico;
	}


	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Usuario [user_id=" + user_id + ", username=" + username + ", contrasena=" + contrasena + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", correo_electronico=" + correo_electronico + ", telefono="
				+ telefono + ", direccion=" + direccion + "]";
	}
	
	

}
