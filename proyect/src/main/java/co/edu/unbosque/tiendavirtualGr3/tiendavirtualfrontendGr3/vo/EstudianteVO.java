package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class EstudianteVO {
	
private int id;
	
	private String correoInstitucional;
	
	private String nombres;
	
	private String apellidos;
	
	private String telefonoFijo;
	
	private String telefonoCel;
	
	private String correoPersonal;
	
	private String programa;
	
	private String fechaNacimiento;
	
	

	public EstudianteVO(int id, String correoInstitucional, String nombres, String apellidos, String telefonoFijo,
			String telefonoCel, String correoPersonal, String programa, String fechaNacimiento) {
		super();
		this.id = id;
		this.correoInstitucional = correoInstitucional;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefonoFijo = telefonoFijo;
		this.telefonoCel = telefonoCel;
		this.correoPersonal = correoPersonal;
		this.programa = programa;
		this.fechaNacimiento = fechaNacimiento;
	}

	public EstudianteVO() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreoInstitucional() {
		return correoInstitucional;
	}

	public void setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = correoInstitucional;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoCel() {
		return telefonoCel;
	}

	public void setTelefonoCel(String telefonoCel) {
		this.telefonoCel = telefonoCel;
	}

	public String getCorreoPersonal() {
		return correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "EstudianteVO [id=" + id + ", correoInstitucional=" + correoInstitucional + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", telefonoFijo=" + telefonoFijo + ", telefonoCel=" + telefonoCel
				+ ", correoPersonal=" + correoPersonal + ", programa=" + programa + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	

}
