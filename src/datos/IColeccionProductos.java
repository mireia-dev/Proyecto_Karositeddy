package datos;

import domain.Producto;

public interface IColeccionProductos {

	public void altaProducto(Producto p);

	public void bajaProducto(int id_producto);

	public void modificarProducto(int id_producto, String nombreNew, int precioNew, int stockNew, String descripcionNew, int id_categoriaNew);
	
	public int recuperarId(String nombre);
	
	public Producto recuperarProducto(int id_producto);
	
	public void listarProductos();
}
