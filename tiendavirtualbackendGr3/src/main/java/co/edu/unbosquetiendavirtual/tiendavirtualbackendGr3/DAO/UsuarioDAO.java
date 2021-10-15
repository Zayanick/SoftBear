package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.*;

public class UsuarioDAO {
	
	public ArrayList<Usuario> listaDeUsuarios() {
		  ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
		  Conexion conex= new Conexion();
		    
		  try {
			   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			   ResultSet res = consulta.executeQuery();
			   while(res.next()){
			    
			    int cedula = Integer.parseInt(res.getString("cedula_usuario"));
			    String email = res.getString("email_usuario");
			    String nombre = res.getString("nombre_usuario");
			    String pass = res.getString("password");    
			    String usr = res.getString("usuario");
			   
			    
			    Usuario persona= new Usuario(cedula, email, nombre, pass, usr);
			    misUsuarios.add(persona);
			          }
			          res.close();
			          consulta.close();
			          conex.desconectar();
			   
			  } catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
			  }
			  return misUsuarios;
			  
		  
	  }
	
	
	public Usuario registrarUsuario(Usuario persona) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO usuarios VALUES ('"+persona.getCedula()+"', '"+persona.getEmail()+"','"
			     +persona.getNombre()+"', '"+persona.getPassword()+"','"+persona.getUsuario()+"')");
	   
	   
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
		
		String sql = "SELECT * FROM tiendagenerica1.usuarios us WHERE us.usuario like ?";
		
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


