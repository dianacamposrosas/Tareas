package utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import usuarios.Usuario;
import libreria.Libreria;

public class DatosComun {
    public static final ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    
    public static ArrayList<String> obtenerDatosComun(Rol rol){
        Scanner scanner = new Scanner(System.in);
        ArrayList <String> datosComun = new ArrayList<>();
        
        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "asistente" : "gerente";
        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));
        
        System.out.println("Ingresa los siguientes datos para continuar");
        
        System.out.println("Ingresa el nombre");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingresa el apellido");
        String apellido = scanner.nextLine();
        
        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();
        
        System.out.println("Ingresa la contraseña");
        String contraseña = scanner.nextLine();
        
        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña));
        return datosComun;
    }
    
    public static String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente = true;
        String telefono = "";

        do {
            System.out.println("\nIngresa el telefono: ");
            telefono = scanner.nextLine();

            telefonoExistente = false;
            for(Usuario i : listaUsuarios) {
                if(i.getTeléfono().equals(telefono)) {
                    telefonoExistente = true;
                    break;
                }
            }

            if(telefonoExistente) {
                System.out.println("El telefono ya se encuentra registrado. Intenta de nuevo.");
            }
        }
        while(telefonoExistente);
        return telefono;
    }


    public static   String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {
            System.out.println("\nIngresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;
            for(Usuario i : listaUsuarios) {
                if(i.getNombreUsuario().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                    break;
                }
            }

            if(nombreUsuarioExistente) {
                System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
            }
        }
        while(nombreUsuarioExistente);
        return nombreUsuario;
    }
}

