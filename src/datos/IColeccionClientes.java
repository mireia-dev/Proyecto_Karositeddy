package datos;

import domain.Cliente;

public interface IColeccionClientes {

	public void altaCliente(Cliente c);

	public void bajaCliente(int id_persona);

	public void modificarCliente(int id_persona, String nombreNew, String apellidosNew, String emailNew, String passwordNew, 
			String fechaNew, int telefonoNew);
	
	public int recuperarId(String nombre);
	
	public Cliente recuperarCliente(int id_persona);

	public void listarClientes();
	
	
}
	
