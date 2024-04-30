package usuarios;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Rol;
import utils.EmpleadoUtils;

public class Administrador extends Usuario implements EmpleadoUtils {
    static Scanner leer = new Scanner(System.in);
    private Double sueldo;
    private String RFC;
    private String INE;
    
    public Administrador(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña,
        Double sueldo, String RFC, String INE) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contraseña); // Llamada al constructor del padre
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s, Sueldo: %.3f, RFC: %s, INE: %s",
                super.toString(), sueldo, RFC, INE);
    }
    
    public static void registrarGerente() {
        Rol rol = usuarioEnLinea.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n***Registro de gerente**");

            System.out.print("\nIngresa el nombre: ");
            String nombre = leer.nextLine();

            System.out.print("Ingresa el apellido: ");
            String apellido = leer.nextLine();

            System.out.print("Ingresa el sueldo: ");
            double sueldo = leer.nextDouble();

            System.out.print("Ingresa la INE: ");
            String INE = leer.nextLine();

            String telefono = registrarTelefonoUsuario();
            String nombreUsuario = registrarNombreUsuario();

            System.out.print("Contraseña: ");
            String clave = leer.nextLine();

            Administrador newAdmin = new Administrador(nombre, apellido, telefono, nombreUsuario, nombreUsuario, sueldo, clave,
                    INE);
            
            if(!usuarios.containsKey(Rol.GERENTE)){
                usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
            }
            System.out.println("Usuario registrado con rol de ADMINISTRADOR y con id " + newAdmin.getID());
        } else {
            System.out.println("\nNo eres un gerente, no puedes registrar a otro gerente");
            return;
        }

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


    public static String registrarNombreUsuario() {
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
    public static void mostrarGerentes() {
        if (usuarios.isEmpty()) {
            System.out.println("\nNo hay gerentes registrados");
        } else {
            System.out.println("\n**Lista de Gerentes**");
            for (ArrayList<Usuario> usuariosRol : usuarios.values()) {
                for(Usuario usuarioActual : usuariosRol){
                    if(usuarioActual.getRol() == Rol.GERENTE){
                        Administrador gerente = (Administrador) usuarioActual;
                        System.out.println(gerente.toString());
                    }
                }
            }
        }
    }
    
    public static void eliminarGerente() {
        Scanner scanner = new Scanner(System.in);

        Rol rol = usuarioEnLinea.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n**Eliminación de gerente");

            System.out.print("\nIngrese el nombre de usuario del gerente a eliminar: ");
            String nombreUsuario = scanner.nextLine();

            int indiceEliminado = 0;

            for (Usuario gerente : listaUsuarios) {
                if (gerente.getNombreUsuario().equals(nombreUsuario)) {
                    listaUsuarios.remove(indiceEliminado);
                    System.out.println("\nGerente eliminado con éxito");
                    return;
                }
                indiceEliminado++;
            }
            System.out.println("\nEl gerente no existe en sistema");

        } else {
            System.out.println("\nNo eres un gerente, no puedes eliminar a otro gerente");
            return;
        }

    }
    
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada por huella");
    }
    
    @Override
    public void checarSalida(){
        System.out.println("Checar salida por huella");
    }
}
