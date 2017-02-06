package domain;

import utilidades.LecturaDatos;

public abstract class Persona {

	private String nombre_per;
	private String apellidos_per;
	private String email;
	private String password;
	private int id_persona;

	public Persona() {

	}
	public Persona(String nombre_per, String apellidos_per, String email, String password, int id_persona) {
		this.nombre_per = nombre_per;
		this.apellidos_per = apellidos_per;
		this.email = email;
		this.password = password;
		this.id_persona = id_persona;
	}

	public String getNombre_per() {
		return nombre_per;
	}


	public void setNombre_per(String nombre_per) {
		this.nombre_per = nombre_per;
	}


	public String getApellidos_per() {
		return apellidos_per;
	}

	public void setApellidos_per(String apellidos_per) {
		this.apellidos_per = apellidos_per;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public void crearPersona() {

		this.nombre_per = LecturaDatos.leerString("Introduzca su Nombre:");
		this.apellidos_per =  LecturaDatos.leerString("Introduzca sus Apellidos:");
		this.email =  LecturaDatos.leerString("Introduzca su Email:");
		this.password =  LecturaDatos.leerString("Introduzca su Password:");

	}

	@Override
	public String toString() {
		return "Persona [nombre_per=" + nombre_per + ", apellidos_per=" + apellidos_per + ", email=" + email
				+ ", password=" + password + ", getNombre_per()=" + getNombre_per() + ", getApellidos_per()="
				+ getApellidos_per() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos_per == null) ? 0 : apellidos_per.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre_per == null) ? 0 : nombre_per.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellidos_per == null) {
			if (other.apellidos_per != null)
				return false;
		} else if (!apellidos_per.equals(other.apellidos_per))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre_per == null) {
			if (other.nombre_per != null)
				return false;
		} else if (!nombre_per.equals(other.nombre_per))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	

}

	