package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Proveedores;

public class ProveedoresDAO {
 
	public ArrayList<Proveedores> listaDeProveedores() {
		  ArrayList<Proveedores> misProveedores = new ArrayList<Proveedores>();
		  Conexion conex= new Conexion();
		    
		  try {
			   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
			   ResultSet res = consulta.executeQuery();
			   while(res.next()){
			    
			    int nit = Integer.parseInt(res.getString("nitproveedor"));
			    String ciudad = res.getString("ciudad_proveedor");
			    String direccion = res.getString("direccion_proveedor");
			    String nombre = res.getString("nombre_proveedor");    
			    String telefono = res.getString("telefono_proveedor");
			   
			    
			    Proveedores persona= new Proveedores(nit, ciudad, direccion, nombre, telefono);
			    misProveedores.add(persona);
			          }
			          res.close();
			          consulta.close();
			          conex.desconectar();
			   
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
			  }
			  return misProveedores;
			  
		  
	  }
	
	
	public Proveedores registrarProveedor(Proveedores persona) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO Proveedores VALUES ('"+persona.getNit()+"', '"+persona.getCiudad()+"','"
			     +persona.getDireccion()+"', '"+persona.getNombre()+"','"+persona.getTelefono()+"')");
	   
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
		  persona = null;
	            System.out.println(e.getMessage());
	  }
	  return persona;
	 }
	
	public Proveedores borrarProveedor(Proveedores persona) 
	 {
	  
	  try {
		  Conexion conex= new Conexion();
	   PreparedStatement estatuto = conex.getConnection().prepareStatement("delete from tiendagenerica1.Proveedores where nitproveedor=?");
	   
	   estatuto.setLong(1, persona.getNit());
	   
	   estatuto.executeUpdate();
	   conex.desconectar();
	   
	   return null;
	   
	  } catch (SQLException e) {
		       System.out.println(e.getMessage());
	  }
	return persona;
}
}
