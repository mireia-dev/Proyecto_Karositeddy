package utilidades;

import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class LecturaDatos {

    //metodo estatico
    public static int leerInteger() {
        return new Scanner(System.in).nextInt();
    }

    public static int leerInteger(String texto) {
        System.out.println(texto);
        return LecturaDatos.leerInteger();
    }

    public static String leerString() {
        return new Scanner(System.in).nextLine();
    }

    public static String leerString(String texto) {
        System.out.println(texto);
        return LecturaDatos.leerString();
    }

    public static double leerDouble() {
        return new Scanner(System.in).nextDouble();
    }

    public static double leerDouble(String texto) {
        System.out.println(texto);
        return LecturaDatos.leerDouble();
    }

    public static boolean leerBoolean() {
        return new Scanner(System.in).nextBoolean();
    }

    public static boolean leerBoolean(String texto) {
        System.out.println(texto);
        return LecturaDatos.leerBoolean();
    }

}
