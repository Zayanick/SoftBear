package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO;

public class Usuario {
	
	
	

	private Integer cedula;
	
	private String email;
	
	private String nombre;
	
	private String password;
	
	private String usuario;
	
	
	public Usuario(Integer cedula, String email, String nombre, String password, String usuario) {
		super();
		this.cedula = cedula;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.usuario = usuario;
	}



	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", email=" + email + ", nombre=" + nombre + ", password=" + password
				+ ", usuario=" + usuario + "]";
	}
	
	
	
	
	
	}

	
	
	


