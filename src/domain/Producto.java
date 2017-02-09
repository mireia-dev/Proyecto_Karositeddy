package domain;

import utilidades.LecturaDatos;

public class Producto {
	private int id_producto;
	private String nombre_prod;
	private double precio_prod;
	private int cantidad_stock;
	private int id_categoria;
	private String descripcion_prod;

	
	public Producto(){	
	}
	public Producto(int id_producto, String nombre_prod, double precio_prod, int cantidad_stock, int id_categoria,
			String descripcion_prod) {
		this.id_producto = id_producto;
		this.nombre_prod = nombre_prod;
		this.precio_prod = precio_prod;
		this.cantidad_stock = cantidad_stock;
		this.id_categoria = id_categoria;
		this.descripcion_prod = descripcion_prod;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre_prod() {
		return nombre_prod;
	}
	public void setNombre_prod(String nombre_prod) {
		this.nombre_prod = nombre_prod;
	}
	public double getPrecio_prod() {
		return precio_prod;
	}
	public void setPrecio_prod(double precio_prod) {
		this.precio_prod = precio_prod;
	}
	public int getCantidad_stock() {
		return cantidad_stock;
	}
	public void setCantidad_stock(int cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getDescripcion_prod() {
		return descripcion_prod;
	}
	public void setDescripcion_prod(String descripcion_prod) {
		this.descripcion_prod = descripcion_prod;
	}
	
	public void crearProducto(){
		
		this.nombre_prod = LecturaDatos.leerString("Introduzca el Nombre:");
		this.precio_prod = LecturaDatos.leerDouble("Introduzca el Precio:");
		this.cantidad_stock = LecturaDatos.leerInteger("Introduzca la Cantidad del Stock:");
		this.descripcion_prod = LecturaDatos.leerString("Introduzca una Descripción:");
		this.id_categoria = LecturaDatos.leerInteger("Introduzca el id de la Categoría:");
	}
	
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre_prod=" + nombre_prod + ", precio_prod=" + precio_prod
				+ ", cantidad_stock=" + cantidad_stock + ", id_categoria=" + id_categoria + ", descripcion_prod="
				+ descripcion_prod + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad_stock;
		result = prime * result + ((descripcion_prod == null) ? 0 : descripcion_prod.hashCode());
		result = prime * result + id_categoria;
		result = prime * result + id_producto;
		result = prime * result + ((nombre_prod == null) ? 0 : nombre_prod.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio_prod);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Producto other = (Producto) obj;
		if (cantidad_stock != other.cantidad_stock)
			return false;
		if (descripcion_prod == null) {
			if (other.descripcion_prod != null)
				return false;
		} else if (!descripcion_prod.equals(other.descripcion_prod))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		if (id_producto != other.id_producto)
			return false;
		if (nombre_prod == null) {
			if (other.nombre_prod != null)
				return false;
		} else if (!nombre_prod.equals(other.nombre_prod))
			return false;
		if (Double.doubleToLongBits(precio_prod) != Double.doubleToLongBits(other.precio_prod))
			return false;
		return true;
	}
	
}
