package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import datos.IColeccionProductos;
import domain.Producto;
import utilidades.DatosBBDD;

public class ColeccionProductosImpl implements IColeccionProductos {
	
	 private List<Producto> listadoProd;

	    public ColeccionProductosImpl() {
	    	listadoProd = new ArrayList<>();
	    }

	    public List<Producto> getListadoProd() {
	        return listadoProd;
	    }

	    public void setListadoProd(List<Producto> listadoProd) {
	        this.listadoProd = listadoProd;
	    }

		@Override
		public void altaProducto(Producto p){
			DatosBBDD bd = new DatosBBDD();
			Connection cn = null;
			try {
				cn = bd.obtenerConexion();
				String sql = "INSERT INTO producto(nombre_prod, precio_prod, cantidad_stock, descripcion_prod, id_categoria)";
				sql += "VALUES(?,?,?,?,?)"; 
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, p.getNombre_prod());
				st.setDouble(2, p.getPrecio_prod());
				st.setInt(3, p.getCantidad_stock());
				st.setString(4, p.getDescripcion_prod());
				st.setInt(5, p.getId_categoria());
				st.execute();
			} catch (SQLException ex) {
				ex.getMessage();
			} finally {
				bd.cerrarConexion(cn);
			}
			
			System.out.println("¡Enhorabuena! ¡Has dado de alta el Producto " + p.getNombre_prod() + "!");
		}

		@Override
		public void bajaProducto(int id_producto) {
			DatosBBDD bd = new DatosBBDD();
			Connection cn = null;
			try {
				cn = bd.obtenerConexion();
				String sql = "DELETE FROM producto WHERE id_producto = ?";
				PreparedStatement st = cn.prepareStatement(sql);
				st.setInt(1, id_producto);
				st.execute();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				bd.cerrarConexion(cn);
			}
			
		}

		@Override
		public void modificarProducto(int id_producto, String nombreNew, int precioNew, int stockNew, String descripcionNew, int id_categoriaNew){
			DatosBBDD bd = new DatosBBDD();
			Connection cn = null;
			try {
				cn = bd.obtenerConexion();
				String sql = "UPDATE producto SET nombre_prod = ?, precio_prod = ?, cantidad_stock = ?, descripcion_prod = ?, id_categoria = ? WHERE id_producto = ?;";
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, nombreNew);
				st.setInt(2, precioNew);
				st.setInt(3, stockNew);
				st.setString(4, descripcionNew);
				st.setInt(5, id_categoriaNew);
				st.setInt(6, id_producto);
				st.execute();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				bd.cerrarConexion(cn);
			}
			System.out.println("Has modificado correctamente el producto");
		}

		public int recuperarId(String nombre){
			Connection cn = null;
			DatosBBDD bd = new DatosBBDD();
			int id_producto = 0;

			try {
				cn = bd.obtenerConexion();
				String sql = "SELECT id_producto FROM producto WHERE nombre_prod = ?";
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, nombre);
				ResultSet rs = st.executeQuery();
				while (rs.next()){
					id_producto = rs.getInt("id_producto");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				bd.cerrarConexion(cn);
			}
			
			return id_producto;
		}
		

		@Override
		public Producto recuperarProducto(int id_producto) {
			Connection cn = null;
			Producto producto = null;
			DatosBBDD bd = new DatosBBDD();

			try {
				cn = bd.obtenerConexion();
				String sql = "SELECT nombre_prod, precio_prod, cantidad_stock, descripcion_prod, id_categoria FROM producto WHERE id_producto = ?";
				PreparedStatement st = cn.prepareStatement(sql);
				st.setInt(1, id_producto);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					producto = new Producto( rs.getInt("id_producto"), rs.getString("nombre_prod"), rs.getInt("precio_prod"), rs.getInt("cantidad_stock"), 
							rs.getInt("id_categoria"),rs.getString("descripcion_prod"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				bd.cerrarConexion(cn);
			}
			return producto;	
		}
		
		public void listarProductos(){
			DatosBBDD bd = new DatosBBDD();
			Connection cn = null;
			ResultSet rs = null;
			Statement st = null;
			
			try{
				cn = bd.obtenerConexion();
				st = cn.createStatement();
				String sql = "SELECT id_producto, nombre_prod, precio_prod, cantidad_stock, descrpcion_prod, id_categoria FROM producto";
				rs = st.executeQuery(sql);	
				while(rs.next()){
					int id_prod = rs.getInt("id_producto");
					String nombre = rs.getString("nombre_prod");
					double precio = rs.getDouble("precio_prod");
					int stock = rs.getInt("cantidad_stock");
					System.out.println("ID: " + id_prod + " Nombre: " + nombre + " Precio: " + precio + " Stock: " + stock);
					
				}
			}catch(SQLException e) {
				System.out.println("Excepción SQL: " + e.getMessage());
				System.out.println("Estado SQL: " + e.getSQLState());
				System.out.println("Código del Error: " + e.getErrorCode());
			} finally {
				bd.cerrarConexion(cn);
			}
		}
		
	    @Override
	    public String toString() {
	        return "Coleccion{" + "listado=" + listadoProd + '}';
	    }

	
}
