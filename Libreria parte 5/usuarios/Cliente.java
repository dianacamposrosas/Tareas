package usuarios;
import utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente extends Usuario {
    private String fechaUnion;
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contraseña) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contraseña);
        this.fechaRegistro = LocalDate.now(); //Trae la fecha actual de la computadora.
    }
    @Override
    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }
//    @Override //Indica que se está sobre escribiendo un método, por eso sale
                //el simbolito de crculitos azules..

    
    public static void registrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Registrar Cliente ----");
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña);
        if(!usuarios.containsKey(Rol.CLIENTE)){
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);
        
        System.out.println("Cliente registrado exitosamente");
    }

    public static void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");
        int x = 1;
        for(ArrayList<Usuario> usuariosRol : usuarios.values()) {
            for(Usuario usuarioActual : usuariosRol){
                if (usuarioActual.getRol() == Rol.CLIENTE){
                    Cliente cliente = (Cliente) usuarioActual;
                    System.out.println("Cliente " + x + ":\n"+cliente.toString());
                    x++;
                }
            }
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
    
    public static void eliminarClientes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n**Eliminación de clientes");

        System.out.print("\nIngrese el nombre de usuario del cliente a eliminar: ");
        String nombreUsuario = scanner.nextLine();

        int indiceEliminado = 0;

        for (Usuario cliente : listaUsuarios) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                listaUsuarios.remove(indiceEliminado);
                System.out.println("\nCliente eliminado con éxito");
                return;
            }
            indiceEliminado++;
        }
        System.out.println("\nEl cliente no existe en sistema");

    }

}



