package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO;

public class Producto {
	
	private Integer codigo;
	private Long nitProveedor;
	private Float ivaCompra;
	private String nombre;
	private Float precioCompra;
	private Float precioVenta;
	
	public Producto() {
		super();
	}
	
	public Producto(Integer codigo, Long nitProveedor, Float ivaCompra, String nombre, Float precioCompra,
			Float precioVenta) {
		super();
		this.codigo = codigo;
		this.nitProveedor = nitProveedor;
		this.ivaCompra = ivaCompra;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public Float getIvaCompra() {
		return ivaCompra;
	}

	public void setIvaCompra(Float ivaCompra) {
		this.ivaCompra = ivaCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nitProveedor=" + nitProveedor + ", ivaCompra=" + ivaCompra
				+ ", nombre=" + nombre + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + "]";
	}
}