package domain;

import utilidades.LecturaDatos;

public class Cliente extends Persona {
	
	private int id_cliente;
	private String fecha_nacimiento;
	private int telefono;
	
	public Cliente(){
		
	}
	public Cliente(String nombre_per, String apellidos_per, String email, String password, int id_persona, int id_cliente, String fecha_nacimiento, int telefono) {
		super();
		this.id_cliente = id_cliente;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public void crearCliente(){
		crearPersona();
		this.fecha_nacimiento = LecturaDatos.leerString("Introduzca su Fecha de Nacimiento:");
		this.telefono =  LecturaDatos.leerInteger("Introduzca su teléfono:");
	}
	
	@Override
	public String toString() {
		return super.toString() + "Cliente [id_cliente=" + id_cliente + ", fecha_nacimiento="
				+ fecha_nacimiento + ", telefono=" + telefono + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
		result = prime * result + id_cliente;
		result = prime * result + telefono;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (fecha_nacimiento == null) {
			if (other.fecha_nacimiento != null)
				return false;
		} else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
			return false;
		if (id_cliente != other.id_cliente)
			return false;
		if (telefono != other.telefono)
			return false;
		return true;
	}
	
	}
	