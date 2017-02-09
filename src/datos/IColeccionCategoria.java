package datos;

import domain.Categoria;

public interface IColeccionCategoria {

	public void altaCategoria(Categoria cat);

	public void bajaCategoria(int id_categoria);

	public void modificarCategoria(int id_categoria, String nombre_catNew, String descripcion_catNew);

	public int recuperarId(String nombre_cat);

	public Categoria recuperarCategoria(int id_categoria);

	public void listarCategoria();

}
