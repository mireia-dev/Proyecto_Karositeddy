package domain;

public class Administrador extends Persona{

	private int id_admin;
	private int id_persona;
	
	public Administrador(){
		
	}
	public Administrador(int id_admin, int id_persona) {
		super();
		this.id_admin = id_admin;
		this.id_persona = id_persona;
	}
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public void crearAdministrador(){
		crearPersona();
	}
	
	@Override
	public String toString() {
		return "Administrador [id_admin=" + id_admin + ", id_persona=" + id_persona + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id_admin;
		result = prime * result + id_persona;
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
		Administrador other = (Administrador) obj;
		if (id_admin != other.id_admin)
			return false;
		if (id_persona != other.id_persona)
			return false;
		return true;
	}

	
	
}

