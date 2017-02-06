package control;

import gui.Pantallas;
import utilidades.LecturaDatos;
import servicio.ISuperServicios;
import servicio.SuperServiciosImpl;

public class Control {

    public void iniciarPrograma() {
        boolean seguir = true;
        do {
            Pantallas.Pantalla01();
            seguir = this.seleccionOpciones();
        } while (seguir);
        System.out.println("   --- Fin de la sesión ---");
    }

    public boolean seleccionOpciones() {
    	ISuperServicios servicios = new SuperServiciosImpl();
        boolean continuar = true;

        try {
            switch (LecturaDatos.leerInteger()) {
                case 1:
                    servicios.altaCliente();
                    break;
                case 2:
                    servicios.modificarCliente();
                    break;
                case 3:
                	servicios.bajaCliente();
                    break;
                case 4:
                	servicios.listarClientes();
                    break;
                case 5:
                	servicios.altaProducto();
                    break;
                case 6:
                	servicios.modificarProducto();
                    break;
                case 7:
                	servicios.bajaProducto();
                    break;
                case 8:
                	servicios.listarProductos();
                    break;
                case 0:
                    continuar = salir();
                    break;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
        return continuar;
    }

    private boolean salir() throws Exception {
        String sino = LecturaDatos.leerString("   Estás seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }

}
