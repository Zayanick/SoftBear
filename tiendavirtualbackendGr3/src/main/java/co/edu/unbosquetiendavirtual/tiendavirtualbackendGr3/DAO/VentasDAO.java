package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Ventas;

public class VentasDAO {
	public ArrayList<Ventas> listaDeVentas() {
		  ArrayList<Ventas> misVentas = new ArrayList<Ventas>();
		  Conexion conex= new Conexion();
		    
		  try {
			   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
			   ResultSet res = consulta.executeQuery();
			   while(res.next()){
			    
			    int codvent = Integer.parseInt(res.getString("codigo_venta"));
			    String ivavent = res.getString("ivaventa");
			    String totalvent = res.getString("total_venta");
			    String valorvent = res.getString("valor_venta");    
			    String clientescedula = res.getString("clientes_cedula_cliente");
			    String usuarioscedula = res.getString("usuarios_cedula_usuario");
			    
			    Ventas ventas= new Ventas(codvent, ivavent, totalvent, valorvent, clientescedula ,usuarioscedula);
			    misVentas.add(ventas);
			          }
			          res.close();
			          consulta.close();
			          conex.desconectar();
			   
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
			  }
			  return misVentas;
			  
		  
	  }
	  
	
	public Ventas registrarVenta(Ventas ventas) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO ventas VALUES ('"+ventas.getCodigoVenta()+"','"+ventas.getIvaVenta()+"','"
			     +ventas.getTotalVenta()+"','"+ventas.getValorVenta()+"','"+ventas.getClienteCedula()+"','"+ventas.getUsuarioCedula()+"')");
	   
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
		  ventas = null;
	            System.out.println(e.getMessage());
	  }
	  return ventas;
	 }
	
	
}
