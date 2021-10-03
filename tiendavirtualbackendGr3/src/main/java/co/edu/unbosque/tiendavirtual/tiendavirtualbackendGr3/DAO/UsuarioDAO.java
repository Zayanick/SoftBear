package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuarios;
public class UsuarioDAO {
	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	public ArrayList<Usuarios> listaDeUsuarios() {
	  ArrayList<Usuarios> misUsuarios = new ArrayList<Usuarios>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    
		int cedula = Integer.parseInt(res.getString("cedula_cliente"));
	    String email = res.getString("email_usuario");
	    String nombre = res.getString("nombre_usuario");
	    String password = res.getString("password");
	    String usuario = res.getString("usuario");
	    
	    Usuarios persona= new Usuarios(cedula, email, nombre, password, usuario);
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
	
	public Usuarios registrarUsuario(Usuarios persona) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO usuarios VALUES ('"+persona.getCedula()+"', '"+persona.getEmail()+"','"
	     +persona.getNombre()+"', '"+persona.getPassword()+"','"+persona.getUsuario()+"','");
	   
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
		  persona = null;
	            System.out.println(e.getMessage());
	  }
	  return persona;
	 }
	
	
	public Usuarios consultarUsuario(Usuarios usr) {
		Conexion conn =  new Conexion();
		Usuarios usuarioEnc = null;
		PreparedStatement ps = null;
		Usuarios usuarioRet = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM unbosque.usuario us WHERE us.nombre like ?";
		
		try {
			ps =  conn.getConnection().prepareStatement(sql);
			ps.setString(1, usr.getNombre());
			rs =  ps.executeQuery();
			while(rs.next()) {
				Integer cedula = rs.getInt(1);
				String email = rs.getString("email_usuario");
			    String nombre = rs.getString("nombre_usuario");
			    String password = rs.getString("password");
			    String usuario = rs.getString("usuario");
				usuarioEnc =  new Usuarios(cedula, email, nombre, password, usuario);
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
