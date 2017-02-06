package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Cliente;
import utilidades.DatosBBDD;
import datos.IColeccionClientes;

public class ColeccionClientesImpl implements IColeccionClientes{
	
	private List<Cliente> listadoCli;

    public ColeccionClientesImpl() {
    	listadoCli = new ArrayList<>();
    }

    public List<Cliente> getListadoCli() {
        return listadoCli;
    }

    public void setListadoCli(List<Cliente> listadoCli) {
        this.listadoCli = listadoCli;
    }
    
	@Override
	public void altaCliente(Cliente c) {
		DatosBBDD bd = new DatosBBDD();
		Connection cn = null;
		ResultSet rs = null;
		int id_persona = 0;		
		
		try {
			cn = bd.obtenerConexion();
			String sql1 = "INSERT INTO persona(nombre_per, apellidos, email, password)";
			sql1 += "VALUES(?,?,?,?);";
			PreparedStatement st = cn.prepareStatement(sql1);
			st.setString(1, c.getNombre_per());
			st.setString(2, c.getApellidos_per());
			st.setString(3, c.getEmail());
			st.setString(4, c.getPassword());
			st.execute();
			
			String sql2 = " SELECT id_persona FROM persona WHERE nombre_per = ?";
			st = cn.prepareStatement(sql2);
			st.setString(1, c.getNombre_per());
			rs = st.executeQuery();
			while (rs.next()){
				id_persona = rs.getInt("id_persona");
			}
			
			String sql3 = " INSERT INTO cliente(fecha_nacimiento, telefono, id_persona) VALUES(?,?,?)";
			st = cn.prepareStatement(sql3);
			st.setString(1, c.getFecha_nacimiento());
			st.setInt(2, c.getTelefono());
			st.setInt(3, id_persona);
			st.execute();

			System.out.println("¡Enhorabuena! ¡Has dado de alta al Cliente " + c.getNombre_per() + "!");
		} catch (SQLException ex) {
			ex.getMessage();
		} finally {
			bd.cerrarConexion(cn);
		}
	}

	@Override
	public void bajaCliente(int id_persona) {
		Connection cn = null;
		DatosBBDD bd = new DatosBBDD();
		try {
			cn = bd.obtenerConexion();
			String sql = "DELETE * FROM persona WHERE id_persona = ?";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setInt(1, id_persona);
			st.execute();
			
			String sql2 = "DELETE * FROM cliente WHERE id_persona = ?";
			st = cn.prepareStatement(sql2);
			st.setInt(1,id_persona);
			st.execute();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}	
	}
	
	@Override
	public void modificarCliente(int id_persona, String nombreNew, String apellidosNew, String emailNew, String passwordNew, 
			String fechaNew, int telefonoNew) {
		DatosBBDD bd = new DatosBBDD();
		Connection cn = null;
		try {
			cn = bd.obtenerConexion();
			String sql = "UPDATE persona SET nombre_per = ?, apellidos = ?, email = ?, password = ? WHERE id_persona = ?;";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setString(1, nombreNew);
			st.setString(2, apellidosNew);
			st.setString(3, emailNew);
			st.setString(4, passwordNew);
			st.setInt(5, id_persona);
			st.execute();

			String sql2 = " UPDATE cliente SET fecha_nacimiento = ?, telefono = ? WHERE id_contacto = ?;";
			st = cn.prepareStatement(sql2);
			st.setString(1, fechaNew);
			st.setInt(2, telefonoNew);
			st.execute();

			System.out.println("¡Enhorabuena! ¡Has modificado el Cliente " + nombreNew + "!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}
	}
	
	public int recuperarId(String nombre){
		Connection cn = null;
		DatosBBDD bd = new DatosBBDD();
		int id_persona = 0;
		
		try {
			cn = bd.obtenerConexion();
			String sql = "SELECT id_persona FROM persona WHERE nombre_per = ?";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setString(1, nombre);
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				id_persona = rs.getInt("id_persona");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}
		return id_persona;
	}
	
	public Cliente recuperarCliente(int id_persona) {
		Connection cn = null;
		Cliente cliente = null;
		DatosBBDD bd = new DatosBBDD();

		try {
			cn = bd.obtenerConexion();
			String sql = "SELECT p.nombre_per, p.apellidos, p.email, p.password, p.id_persona, c.id_cliente, c.fecha_nacimiento, c.telefono FROM cliente c, persona p WHERE id_cliente = ?";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setInt(1, id_persona);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				cliente = new Cliente(rs.getString("nombre_per"), rs.getString("apellidos"), rs.getString("email"), rs.getString("password"),
						 rs.getInt("id_persona"), rs.getInt("id_cliente"), rs.getString("fecha_nacimiento"), rs.getInt("telefono"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}
		return cliente;
	}
	
	public void listarClientes(){
		DatosBBDD bd = new DatosBBDD();
		Connection cn = null;
		ResultSet rs = null;
		Statement st = null;

		try {
			cn = bd.obtenerConexion();
			st = cn.createStatement();
			String sql = "SELECT p.nombre_per, p.apellidos, c.fecha_nacimiento, c.telefono, p.email, p.password FROM persona p INNER JOIN cliente c ON c.id_persona = p.id_persona";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String nombre = rs.getString("nombre_per");
				String apellidos = rs.getString("apellidos");
				String fecha_nac = rs.getString("fecha_nacimiento");
				int telefono = rs.getInt("telefono");
				String email = rs.getString("email");
				String pwd = rs.getString("password");
				System.out.println("Nombre: " + nombre + ", Apellidos: " + apellidos + ", Fecha de Nacimiento: " + fecha_nac
						+ ", Teléfono: " + telefono + ", Email: " + email + ", Contraseña: " + pwd);
			}
		} catch (SQLException e) {
			System.out.println("Excepción SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		} finally {
			bd.cerrarConexion(cn);
		}
	}

	@Override
	public String toString() {
		return "ColeccionClientesImpl [listadoCli=" + listadoCli + "]";
	}
}