package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO;


public class Ventas {
	private int codigoVenta;
	private String ivaVenta;
	private String totalVenta;
	private String valorVenta;
	private String clienteCedula;
	private String usuarioCedula;
	
	public Ventas(int codigoVenta, String ivavent, String totalvent, String valorvent, String clientescedula,
			String usuarioscedula) {
		super();
		this.codigoVenta = codigoVenta;
		this.ivaVenta = ivavent;
		this.totalVenta = totalvent;
		this.valorVenta = valorvent;
		this.clienteCedula = clientescedula;
		this.usuarioCedula = usuarioscedula;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}



	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}



	public String getIvaVenta() {
		return ivaVenta;
	}



	public void setIvaVenta(String ivaVenta) {
		this.ivaVenta = ivaVenta;
	}



	public String getTotalVenta() {
		return totalVenta;
	}



	public void setTotalVenta(String totalVenta) {
		this.totalVenta = totalVenta;
	}



	public String getValorVenta() {
		return valorVenta;
	}



	public void setValorVenta(String valorVenta) {
		this.valorVenta = valorVenta;
	}



	public String getClienteCedula() {
		return clienteCedula;
	}



	public void setClienteCedula(String clienteCedula) {
		this.clienteCedula = clienteCedula;
	}



	public String getUsuarioCedula() {
		return usuarioCedula;
	}



	public void setUsuarioCedula(String usuarioCedula) {
		this.usuarioCedula = usuarioCedula;
	}



	@Override
	public String toString() {
		return "Ventas [codigoVenta=" + codigoVenta + ", ivaVenta=" + ivaVenta + ", totalVenta=" + totalVenta
				+ ", valorVenta=" + valorVenta + ", clienteCedula=" + clienteCedula + ", usuarioCedula=" + usuarioCedula
				+ "]";
	}
	
}