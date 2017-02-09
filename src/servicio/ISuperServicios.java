package servicio;


import domain.Cliente;
import domain.Producto;
import domain.Categoria;

public interface ISuperServicios {

	public void altaProducto();

	public void altaProducto(Producto p);

	public void bajaProducto();

	public void bajaProducto(int id_producto);

	public void modificarProducto();

	public void modificarProducto(int id_producto, String nombreNew, int precioNew, int stockNew, String descripcionNew, int id_categoriaNew);
	
	public void listarProductos();
	
	public void altaCliente();

	public void altaCliente(Cliente c);

	public void bajaCliente();

	public void bajaCliente(int id_persona);

	public void modificarCliente();

	public void modificarCliente(int id_persona, String nombreNew, String apellidosNew, String emailNew, String passwordNew, 
			String fechaNew, int telefonoNew);
	
	public void listarClientes();
	
	public void altaCategoria();
	
	public void altaCategoria(Categoria cat);

	public void bajaCategoria();
	
	public void bajaCategoria(int id_categoria);

	public void modificarCategoria();
	
	public void modificarCategoria(int id_categoria, String nombre_catNew, String descripcion_catNew);

	public void listarCategoria();
}
