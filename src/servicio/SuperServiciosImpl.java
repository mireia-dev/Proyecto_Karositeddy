package servicio;

import datos.ColeccionCategoriaImpl;
import datos.ColeccionClientesImpl;
import datos.ColeccionProductosImpl;
import datos.IColeccionCategoria;
import datos.IColeccionProductos;
import datos.IColeccionClientes;
import domain.Categoria;
import domain.Cliente;
import domain.Producto;
import utilidades.LecturaDatos;

public class SuperServiciosImpl implements ISuperServicios{

    IColeccionProductos colProd = new ColeccionProductosImpl();
    IColeccionClientes colCli = new ColeccionClientesImpl();
    IColeccionCategoria colCat= new ColeccionCategoriaImpl();
 
    @Override
	public void altaProducto() {
    	Producto p = new Producto();
		p.crearProducto();
		altaProducto(p);
		
	}

	@Override
	public void altaProducto(Producto p) {
		colProd.altaProducto(p);
		
	}

	@Override
	public void bajaProducto(){
		String nombre = LecturaDatos.leerString("Introduce el nombre del producto a eliminar: ");
		int id_producto = colProd.recuperarId(nombre);
		Producto producto = colProd.recuperarProducto(id_producto);

		if (producto == null) {
			System.out.println("EL PRODUCTO NO EXISTE!! Por lo tanto no se puede borrar");
		} else {
			bajaProducto(id_producto);
			
			System.out.println("¡El Producto ha sido Eliminado!");
		}
	}

	@Override
	public void bajaProducto(int id_producto) {
		colProd.bajaProducto(id_producto);	
	}

	@Override
	public void modificarProducto() {
		String nombre = LecturaDatos.leerString("Introduce el nombre del producto a eliminar: ");
		int id_producto = colProd.recuperarId(nombre);
		Producto producto = colProd.recuperarProducto(id_producto);
		
		if (producto == null) {
			System.out.println("NO EXISTE ESTE PRODUCTO, no se puede borrar");
		} else {
			String nombreNew = LecturaDatos.leerString("Introduce el nombre nuevo: ");
			int precioNew = LecturaDatos.leerInteger("Introduce el precio nuevo: ");
			int stockNew = LecturaDatos.leerInteger("Introduce la nueva cantidad: "); 
			String descripcionNew = LecturaDatos.leerString("Introduce la nueva descripción: ");
			// POSIBLE MEJORA: mostrar la lista de categorías con sus id
			int id_categoriaNew = LecturaDatos.leerInteger("Introduce la nueva categoría: ");
			modificarProducto(id_producto, nombreNew, precioNew, stockNew, descripcionNew, id_categoriaNew);	
		}	
		
	}

	@Override
	public void modificarProducto(int id_producto, String nombreNew, int precioNew, int stockNew, String descripcionNew, int id_categoriaNew) {
		colProd.modificarProducto(id_producto, nombreNew, precioNew, stockNew, descripcionNew, id_categoriaNew) ;
		
	}
	
	public void listarProductos(){
		colProd.listarProductos();
	}
	
	
	//Clientes
	
	
	@Override
	public void altaCliente() {
		Cliente c = new Cliente();
		c.crearCliente();
		altaCliente(c);
	}

	@Override
	public void altaCliente(Cliente c) {
		colCli.altaCliente(c);
		
	}

	@Override
	public void bajaCliente() {
		String nombre = LecturaDatos.leerString("Introduce el nombre del cliente a eliminar: ");
		int id_persona = colCli.recuperarId(nombre);
		Cliente cliente = colCli.recuperarCliente(id_persona);

		if (cliente == null) {
			System.out.println("NO EXISTE ESTE CLIENTE, no se puede borrar");
		} else {
			bajaCliente(id_persona);
			
			System.out.println("¡El Cliente ha sido Eliminado!");
		}
		
	}

	@Override
	public void bajaCliente(int id_persona) {
		colCli.bajaCliente(id_persona);
		
	}

	@Override
	public void modificarCliente(){
		String nombre = LecturaDatos.leerString("Introduce el nombre del producto a eliminar: ");
		int id_persona = colCli.recuperarId(nombre);
		Cliente cliente = colCli.recuperarCliente(id_persona);
		
		if (cliente == null) {
			System.out.println("NO EXISTE ESTE CLIENTE, no se puede borrar");
		} else {
			String nombreNew = LecturaDatos.leerString("Introduce el nombre nuevo: ");
			String apellidosNew = LecturaDatos.leerString("Introduce los apellidos nuevos: ");
			String emailNew = LecturaDatos.leerString("Introduce el nuevo email: ");
			String passwordNew = LecturaDatos.leerString("Introduce el nuevo password: ");
			String fechaNew = LecturaDatos.leerString("Introduce la nueva fecha de nacimiento: ");
			int telefonoNew = LecturaDatos.leerInteger("Introduce el telefono nuevo: ");
			modificarCliente(id_persona, nombreNew, apellidosNew, emailNew, passwordNew, fechaNew, telefonoNew);			
		}	
	}

	public void listarClientes() {
		colCli.listarClientes();
	}

	@Override
	public void modificarCliente(int id_persona, String nombreNew, String apellidosNew, String emailNew, String passwordNew, 
			String fechaNew, int telefonoNew) {
		colCli.modificarCliente(id_persona, nombreNew, apellidosNew, emailNew, passwordNew, fechaNew, telefonoNew);
		
	}

	
	//Categorias
	
	
	@Override
	public void altaCategoria() {
		Categoria cat = new Categoria();
		cat.crearCategoria();
		altaCategoria(cat);
	}
	
	@Override
	public void altaCategoria(Categoria cat) {
		colCat.altaCategoria(cat);
	}

	@Override
	public void bajaCategoria() {
		String nombre_cat = LecturaDatos.leerString("Introduce el nombre de la Categoria a eliminar: ");
		int id_categoria = colCat.recuperarId(nombre_cat);
		Categoria categoria = colCat.recuperarCategoria(id_categoria);

		if (categoria == null) {
			System.out.println("NO EXISTE ESTA CATEGORIA, no se puede borrar");
		} else {
			bajaCategoria(id_categoria);
			
			System.out.println("¡El Cliente ha sido Eliminado!");
		}
		
	}
	
	@Override
	public void bajaCategoria(int id_categoria) {
		colCat.bajaCategoria(id_categoria);
	}

	@Override
	public void modificarCategoria(){
	String nombre_cat = LecturaDatos.leerString("Introduce el nombre de la categoria a modificar: ");
	int id_categoria = colCat.recuperarId(nombre_cat);
	
	if (id_categoria == 0) {
		System.out.println("NO EXISTE LA CATEGORIA, no se puede borrar");
	} else {
		String nombre_catNew = LecturaDatos.leerString("Introduce el nuevo nombre de la categoría: ");
		String descripcion_catNew = LecturaDatos.leerString("Introduce la nueva descripción de la categoría: ");
		
		modificarCategoria(id_categoria, nombre_catNew,  descripcion_catNew);			
		}
	}
	
	@Override
	public void modificarCategoria(int id_categoria, String nombre_catNew, String descripcion_catNew) {
		colCat.modificarCategoria(id_categoria, nombre_catNew, descripcion_catNew);
	}
	
	@Override
	public void listarCategoria() {
		colCat.listarCategoria();
	}

}
