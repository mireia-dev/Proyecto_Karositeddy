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
		ResultSet rs = null;
		int id_categoria = 0;		
		
		try {
			cn = bd.obtenerConexion();
			String sql1 = "INSERT INTO persona(nombre_cat, descripcion_cat, id_categoria)";
			sql1 += "VALUES(?,?,?,?);";
			PreparedStatement st = cn.prepareStatement(sql1);
			st.setString(1, cat.getNombre_cat());
			st.setString(2, cat.getDescripcion_cat());
			st.setInt(3, cat.getId_categoria());
			st.execute();
			
			String sql2 = " SELECT id_categoria FROM categoria WHERE nombre_cat = ?";
			st = cn.prepareStatement(sql2);
			st.setString(1, cat.getNombre_cat());
			rs = st.executeQuery();
			while (rs.next()){
				id_categoria = rs.getInt("id_categoria");
			}

			System.out.println("¡Enhorabuena! ¡Has dado de alta la Categoria " + cat.getNombre_cat() + "!");
		} catch (SQLException ex) {
			ex.getMessage();
		} finally {
			bd.cerrarConexion(cn);
		}
	}

	@Override
	public void bajaCategoria(int id_categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCategoria(int id_categoria, String nombre_catNew, int id_categoriaNew,
			String descripcion_catNew) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int recuperarId(String nombre_cat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Categoria recuperarCategoria(int id_categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listarCategoria() {
		// TODO Auto-generated method stub
		
	}
	
}
