package utilidades;

import java.sql.*;

public class DatosBBDD {
	
	
	public Connection obtenerConexion(){
        Connection cn=null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/karositeddy","root","1111");
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }

    public void cerrarConexion(Connection cn){
        try {

                if(cn!=null){
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
}