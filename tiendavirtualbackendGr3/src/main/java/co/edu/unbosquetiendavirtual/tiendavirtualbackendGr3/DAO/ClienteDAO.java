package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


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
	public Usuario consultarUsuario(Usuario usr) {
		Conexion conn =  new Conexion();
		Usuario usuarioEnc = null;
		PreparedStatement ps = null;
		Usuario usuarioRet = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tiendagenerica1.usuarios us WHERE us.nombre like ?";
		
		try {
			ps =  conn.getConnection().prepareStatement(sql);
			ps.setString(1, usr.getNombre());
			rs =  ps.executeQuery();
			while(rs.next()) {
				Integer cedula = rs.getInt(1);
				String email =  rs.getString(2);
				String nombre =  rs.getString(3);
				String pass =  rs.getString(4);
				String usuario = rs.getString(5);
				usuarioEnc =  new Usuario(cedula, email, nombre, pass, usuario);
			}
			if(usuarioEnc != null) {
			if(usuarioEnc.getPassword().equals(usr.getPassword())) {
				usuarioRet = usuarioEnc;
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.desconectar();
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return usuarioRet;
	}
}
