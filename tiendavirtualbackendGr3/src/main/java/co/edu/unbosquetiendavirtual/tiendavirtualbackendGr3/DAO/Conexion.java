package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//Credenciales base de datos
	static String bd = "tiendagenerica1";
	static String login = "root";
	static String password = "123456";
	static String url = "jdbc:mysql://localhost/"+bd; 

	   Connection connection = null;

	   /** Constructor de DbConnection */
	   public Conexion() {
	      try{
	         //obtenemos el driver de para mysql
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 //  Class.forName("org.mariadb.jdbc.Driver");
	         //obtenemos la conexión
	         connection = DriverManager.getConnection(url,login,password);

	         if (connection!=null){
	            System.out.println("Conexión a base de datos "+bd+" OK\n");
	         }
	      }
	      catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }
	   }
	   /**Permite retornar la conexión*/
	   public Connection getConnection(){
	      return connection;
	   }

	   public void desconectar(){
	      connection = null;
	   }


}
