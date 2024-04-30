package usuarios;
import utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import utils.EmpleadoUtils;

public class Asistente extends Usuario implements EmpleadoUtils {
    static Scanner leer= new Scanner (System.in);
    private LocalDate fechaInicio;
    private Double sueldo;
    private String RFC;
    private String INE;

    public Asistente(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña,
                     Double sueldo, String RFC, String INE) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contraseña);
        this.fechaInicio = LocalDate.now();
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }
    @Override
    public String toString(){
        return String.format("%s, Fecha de ingreso: %s, Sueldo: %.3f, RFC: %s, INE: %s "+
                super.toString(), fechaInicio, sueldo, RFC, INE);
    }
    
    public static void registrarAsistente() {

        Rol rol = usuarioEnLinea.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n***Registro de asistente***");

            System.out.print("\nIngresa el nombre: ");
            String nombre = leer.nextLine();

            System.out.print("Ingresa el apellido: ");
            String apellido = leer.nextLine();

            System.out.print("Ingresa el sueldo: ");
            double sueldo = leer.nextDouble();

            System.out.print("Ingresa el RFC: ");
            String RFC = leer.nextLine();

            System.out.print("Ingresa la INE: ");
            String INE = leer.nextLine();

            String telefono = registrarTelefonoUsuario();
            String nombreUsuario = registrarNombreUsuario();

            System.out.print("Contraseña: ");
            String clave = leer.nextLine();

            Asistente newAsistente = new Asistente(nombre, apellido, telefono, nombreUsuario, clave, sueldo, RFC, INE);
            
            if(!usuarios.containsKey(Rol.ASISTENTE)){
                usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
            }
            usuarios.get(Rol.ASISTENTE).add(newAsistente);
            System.out.println("Usuario registrado con rol de ASISTENTE y con id" + newAsistente.getID());
        } else {
            System.out.println("nNo eres un gerente, no puedes registrar a un asistente");
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
    
    public static void mostrarAsistentes() {
        if (!usuarios.containsKey(Rol.ASISTENTE) || usuarios.get(Rol.ASISTENTE).isEmpty()) {
            System.out.println("\nNo hay asistentes registrados");
        } else {
            System.out.println("\n**Lista de Asistentes**");
            for (ArrayList<Usuario> usuariosRol : usuarios.values()) {
                for (Usuario usuarioActual : usuariosRol) {
                    if (usuarioActual.getRol() == Rol.ASISTENTE) {
                        Asistente asistente = (Asistente) usuarioActual;
                        System.out.println(asistente.toString());
                    }
                }
            }
        }
    }
    
    public static void eliminarAsistente() {
        Scanner scanner = new Scanner(System.in);

        Rol rol = usuarioEnLinea.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n**Eliminación de asistente");

            System.out.print("\nIngrese el nombre de usuario del asistente a eliminar: ");
            String nombreUsuario = scanner.nextLine();

            int indiceEliminado = 0;

            for (Usuario asistente : listaUsuarios) {
                if (asistente.getNombreUsuario().equals(nombreUsuario)) {
                    listaUsuarios.remove(indiceEliminado);
                    System.out.println("\nAsistente eliminado con éxito");
                    return;
                }
                indiceEliminado++;
            }
            System.out.println("\nEl asistente no existe en sistema");

        } else {
            System.out.println("\nNo eres un gerente no puede eliminar un asistente");
            return;
        }

    }
    
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada por correo");
    }
    
    @Override
    public void checarSalida(){
        System.out.println("Checar salida por correo");
    }
}
