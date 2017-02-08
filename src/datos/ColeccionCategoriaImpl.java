package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilidades.DatosBBDD;
import domain.Categoria;
import datos.IColeccionCategoria;

public class ColeccionCategoriaImpl implements IColeccionCategoria{

	private List<Categoria> ListCat;
	
	public ColeccionCategoriaImpl(){
		ListCat = new ArrayList<>();
	}

	public List<Categoria> getListCat() {
		return ListCat;
	}

	public void setListCat(List<Categoria> listCat) {
		ListCat = listCat;
	}

	@Override
	public void altaCategoria(Categoria cat) {
		DatosBBDD bd = new DatosBBDD();
		Connection cn = null;
		
		try {
			cn = bd.obtenerConexion();
			String sql1 = "INSERT INTO categoria(nombre_cat, descripcion_cat)";
			sql1 += "VALUES(?,?);";
			PreparedStatement st = cn.prepareStatement(sql1);
			st.setString(1, cat.getNombre_cat());
			st.setString(2, cat.getDescripcion_cat());
			st.execute();

			System.out.println("¡Enhorabuena! ¡Has dado de alta la Categoria " + cat.getNombre_cat() + "!");
		} catch (SQLException ex) {
			ex.getMessage();
		} finally {
			bd.cerrarConexion(cn);
		}
	}

	@Override
	public void bajaCategoria(int id_categoria) {
		Connection cn = null;
		DatosBBDD bd = new DatosBBDD();
		try {
			cn = bd.obtenerConexion();
			String sql = "DELETE * FROM categoria WHERE id_categoria = ?";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setInt(1, id_categoria);
			st.execute();
	
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}	
	}

	@Override
	public void modificarCategoria(int id_categoria, String nombre_catNew, int id_categoriaNew, String descripcion_catNew){
		DatosBBDD bd = new DatosBBDD();
		Connection cn = null;
		try {
			cn = bd.obtenerConexion();
			String sql = "UPDATE categoria SET nombre_cat = ?, descripcion_cat = ?, id_categoriaNew = ? WHERE id_categoria = ?;";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setString(1, nombre_catNew);
			st.setString(2, descripcion_catNew);
			st.setInt(3, id_categoriaNew);
			st.execute();

			System.out.println("¡Enhorabuena! ¡Has modificado el Cliente " + nombre_catNew + "!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}
	}

	@Override
	public int recuperarId(String nombre_cat) {
		Connection cn = null;
		DatosBBDD bd = new DatosBBDD();
		int id_categoria = 0;
		
		try {
			cn = bd.obtenerConexion();
			String sql = "SELECT id_categoria FROM categoria WHERE nombre_cat = ?";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setString(1, nombre_cat);
			ResultSet rs = st.executeQuery();
			while (rs.next()){
				id_categoria = rs.getInt("id_categoria");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}
		return id_categoria;
	}

	@Override
	public Categoria recuperarCategoria(int id_categoria) {
		Connection cn = null;
		Categoria categoria = null;
		DatosBBDD bd = new DatosBBDD();

		try {
			cn = bd.obtenerConexion();
			String sql = "SELECT nombre_cat, descripcion_cat, id_categoria FROM categoria WHERE id_categoria = ?";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setInt(1, id_categoria);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				categoria = new Categoria (rs.getInt("id_categoria"), rs.getString("nombre_cat"), rs.getString("descripcion_cat"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			bd.cerrarConexion(cn);
		}
		return categoria;
	}

	@Override
	public void listarCategoria() {
		DatosBBDD bd = new DatosBBDD();
		Connection cn = null;
		ResultSet rs = null;
		Statement st = null;

		try {
			cn = bd.obtenerConexion();
			st = cn.createStatement();
			String sql = "SELECT id_categoria, nombre_cat, descripcion_cat FROM persona p INNER JOIN cliente c ON c.id_persona = p.id_persona";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int categoria = rs.getInt("id_categoria");
				String nombre = rs.getString("nombre_cat");
				String descripcion = rs.getString("descripcion_cat");
				System.out.println( "Categoria: " + categoria + ", Nombre: " + nombre + ", Descripcion: " + descripcion);
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
		return "ColeccionCategoriaImpl [ListCat=" + ListCat + "]";
	}
	
}
