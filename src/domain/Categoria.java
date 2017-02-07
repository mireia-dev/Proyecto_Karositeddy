package domain;

import utilidades.LecturaDatos;

public class Categoria {
	private int id_categoria;
	private String nombre_cat;
	private String descripcion_cat;
	
	public Categoria() {
	}
	public Categoria(int id_categoria, String nombre_cat, String descripcion_cat) {
		this.id_categoria = id_categoria;
		this.nombre_cat = nombre_cat;
		this.descripcion_cat = descripcion_cat;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre_cat() {
		return nombre_cat;
	}
	public void setNombre_cat(String nombre_cat) {
		this.nombre_cat = nombre_cat;
	}
	public void crearCategoria(){
		this.nombre_cat = LecturaDatos.leerString("Introduzca el Nombre de la Categoria:");
	}
	public void listaCategorias(){
	}
	public String getDescripcion_cat() {
		return descripcion_cat;
	}
	public void setDescripcion_cat(String descripcion_cat) {
		this.descripcion_cat = descripcion_cat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion_cat == null) ? 0 : descripcion_cat.hashCode());
		result = prime * result + id_categoria;
		result = prime * result + ((nombre_cat == null) ? 0 : nombre_cat.hashCode());
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
		Categoria other = (Categoria) obj;
		if (descripcion_cat == null) {
			if (other.descripcion_cat != null)
				return false;
		} else if (!descripcion_cat.equals(other.descripcion_cat))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		if (nombre_cat == null) {
			if (other.nombre_cat != null)
				return false;
		} else if (!nombre_cat.equals(other.nombre_cat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nombre_cat=" + nombre_cat + ", descripcion_cat="
				+ descripcion_cat + "]";
	}
	
}
