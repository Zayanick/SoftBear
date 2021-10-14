package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class ClientesVO {
	private int cedula;
	private String direccion;
	private String email;
	private String nombre;
	private String telefono;
	
	
	
	public ClientesVO(int cedula, String direccion, String email, String nombre, String telefono) {
		super();
		this.cedula = cedula;
		this.direccion = direccion;
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
	public ClientesVO() {
		
	}


	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "ClientesVO [cedula=" + cedula + ", direccion=" + direccion + ", email=" + email + ", nombre=" + nombre
				+ ", telefono=" + telefono + "]";
	}


	
	

}
