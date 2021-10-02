package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class UsuarioVO {
	
	private Integer cedula;
	
	private String nombre;
	
	private String contrasena;
	
	private String rol ;
	
	private String msj;
	
	

	public UsuarioVO(Integer cedula, String nombre, String contrasena, String rol) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.rol = rol;
		this.msj="vacio";
	}
	
	public UsuarioVO() {}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

	@Override
	public String toString() {
		return "UsuarioVO [cedula=" + cedula + ", nombre=" + nombre + ", contrasena=" + contrasena + ", rol=" + rol
				+ "]";
	}
	
	

}
