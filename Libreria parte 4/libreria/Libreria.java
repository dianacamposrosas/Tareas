package libreria;
import java.util.ArrayList;
import java.util.Scanner;
import usuarios.Usuario;
import utils.Rol;
import usuarios.Cliente;
import usuarios.usuarioEnLinea;
import usuarios.Administrador;
import usuarios.Asistente;
import java.util.HashMap;

public class Libreria {
    
    //@SuppressWarnings("rawTypes")
    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Usuario> usuariosTotales = new ArrayList<Usuario>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();
    Scanner leer = new Scanner(System.in);
    
    public Usuario verificarInicioSesión (String nombreUsuario, String contraseña){
        for(Usuario usuario : usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                if(usuario.getContraseña().equals(contraseña)) {
                    return usuario;
                }
                return null;
            }
        }
        return null;
    }
    
    public void registrarLibro() {
        System.out.println("Ingresa el título: ");
        String tittle = leer.nextLine();
        System.out.println("Ingresa la fecha de lanzamiento: ");
        String fechaLanzamiento = leer.nextLine();
        System.out.println("Ingresa el nombre del autor: ");
        String authorName = leer.nextLine();
        Libro newBook = new Libro(tittle, fechaLanzamiento, authorName);
        System.out.println("Código de barras: " + newBook.getIDlibro());
        libros.add(newBook);
    }
    public void registrarCliente() {
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

    public void mostrarClientes() {
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


    public String registrarTelefonoUsuario() {
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


    public String registrarNombreUsuario() {
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
     public void registrarGerente() {
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

    public void registrarAsistente() {

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
    public void mostrarGerentes() {
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

    public void mostrarAsistentes() {
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

    public void eliminarClientes() {
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

    public void eliminarAsistente() {
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

    public void eliminarGerente() {
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

    public void mostrarLibros() {
        for (Libro buscarLibro : libros) {
            System.out.println(buscarLibro.mostrarLibros());
        }
    }

}
