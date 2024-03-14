package tarea8.u2;
import java.util.Scanner;
public class Tarea8U2 {
    
public static void main(String[] args) {
    
    Librería libreria = new Librería();
    Scanner leer = new Scanner(System.in);

    int opcion;
        do {
            System.out.println("****MENÚ****");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar libro");
            System.out.println("3. Rentar libro");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Listar libros");
            System.out.println("6. Listar libros no rentadps");
            System.out.println("7. Listar libros alquilados");
            System.out.println("8. Salir");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    libreria.agregarUsuario();
                    break;
                case 2:
                    libreria.agregarLibro();
                    break;
                case 3:
                System.out.println("Ingrese nombre del usuario: ");
                String nombre = leer.nextLine();
                System.out.println("Ingrese título del libro:");
                String título = leer.nextLine();
                Usuarios usuario = libreria.getUsuarioPorNombre(nombre);
                Libros libro = libreria.getLibroPorTítulo(título);
                libreria.rentarLibro(usuario, libro);
                libreria.rentarLibro(usuario, libro);
                    break;
                case 4:
                    libreria.listarUsuarios();
                    break;
                case 5:
                    libreria.listarLibros();
                    break;
                case 6:
                    libreria.librosNoRentados();
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 8);
    }
    
}
