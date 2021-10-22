package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.util.List;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.*;

public class ClienteDAO {
	
	
	public ArrayList<Clientes> listaDeClientes() {
		  ArrayList<Clientes> misClientes = new ArrayList<Clientes>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    
		    int cedula = Integer.parseInt(res.getString("cedula_cliente"));
		    String direccion = res.getString("direccion_cliente");
		    String email = res.getString("email_cliente");
		    String nombre = res.getString("nombre_cliente");
		    String telefono = res.getString("telefono_cliente");
		   
		    
		    Clientes persona= new Clientes(cedula, direccion, email, nombre, telefono);
		    misClientes.add(persona);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		  }
		  return misClientes;
		  
	 }
	
	
	public Clientes registrarCliente(Clientes persona) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO clientes VALUES ('"+persona.getCedula()+"', '"+persona.getDireccion()+"','"
			     +persona.getEmail()+"', '"+persona.getNombre()+"','"+persona.getTelefono()+"')");
	   
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
		  persona = null;
	            System.out.println(e.getMessage());
	  }
	  return persona;
	 }
	
	public void eliminarProductos() 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("DELETE FROM productos");
	   
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {  
	            System.out.println(e.getMessage());
	  }
	 }
	
	public void SafeUpdate() {
		 Conexion conex= new Conexion();
		  try {
		   Statement estatuto = conex.getConnection().createStatement();
		   estatuto.executeUpdate("SET SQL_SAFE_UPDATES = 0;");
		   
		   
		   estatuto.close();
		   conex.desconectar();
		   
		  } catch (SQLException e) {  
		            System.out.println(e.getMessage());
		  }
   }
	
	public Producto registrarProducto(Producto p) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();  
	   estatuto.executeUpdate("INSERT INTO productos VALUES ('"+p.getCodigo()+"', '"+p.getIvaCompra()+"','"
	   +p.getNombre()+"', '"+p.getPrecioCompra()+"','"+p.getPrecioVenta()+"', '"+p.getNitProveedor()+"')");
	   
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
		  p = null;
	            System.out.println(e.getMessage());
	  }
	  return p;
	 }
	
	public Clientes borrarCliente(Clientes persona) 
	 {
	  
	  try {
		  Conexion conex= new Conexion();
	   PreparedStatement estatuto = conex.getConnection().prepareStatement("delete from tiendagenerica1.clientes where cedula_cliente=?");
	   
	   estatuto.setLong(1, persona.getCedula());
	   
	   estatuto.executeUpdate();
	   conex.desconectar();
	   
	   return null;
	   
	  } catch (SQLException e) {
		       System.out.println(e.getMessage());
	  }
	return persona;
}
	
}
