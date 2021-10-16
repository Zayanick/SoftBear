package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class VentasVO {
	private int codigoVenta;
	private String ivaVenta;
	private String totalVenta;
	private String valorVenta;
	private String clienteCedula;
	private String usuarioCedula;
	
	public VentasVO(int codigoVenta, String ivaVenta, String totalVenta, String valorVenta, String clienteCedula,
			String usuarioCedula) {
		super();
		this.codigoVenta = codigoVenta;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
		this.valorVenta = valorVenta;
		this.clienteCedula = clienteCedula;
		this.usuarioCedula = usuarioCedula;
	}


	public VentasVO() {
		super();
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
		return "VentasVO [codigoVenta=" + codigoVenta + ", ivaVenta=" + ivaVenta + ", totalVenta=" + totalVenta
				+ ", valorVenta=" + valorVenta + ", clienteCedula=" + clienteCedula + ", usuarioCedula=" + usuarioCedula
				+ "]";
	}
}
