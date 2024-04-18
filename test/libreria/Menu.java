package libreria;
import java.util.Scanner;
import usuarios.Usuario;
import usuarios.usuarioEnLinea;


public class Menu {
    static Scanner scanner= new Scanner (System.in);
    private Libreria libreria = new Libreria();
    Usuario usuarioActual;
    
    public Usuario iniciarSesión() {
        boolean datosCorrectos = false;
        do {
        System.out.println("\nBienvenido al Sistema de la Biblioteca");
        System.out.println("Para continuar, inicia sesión\n");
        
        System.out.println("Ingresa tu usuario");
        String usuario = scanner.nextLine();
        
        System.out.println("Ingresa tu contraseña");
        String contraseña = scanner.nextLine();
        
        usuarioActual= libreria.verificarInicioSesión(usuario, contraseña);
        
        if (usuarioActual!=null) {
            datosCorrectos = true;
            usuarioEnLinea.obtenerInstancia().setUsuarioActual(usuarioActual);
            seleccionarMenu();
        } else {
            System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo");
            }
        } while (!datosCorrectos);
        return null;
    }
    
    private void seleccionarMenu (){
        Usuario usuario = usuarioEnLinea.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE: mostrarMenuCliente(usuario.getNombreUsuario());
            case ASISTENTE: mostrarMenuAsistente(usuario.getNombreUsuario());
            case GERENTE: mostrarMenuGerente(usuario.getNombreUsuario());
        }
    }
    
    public void mostrarMenuCliente(String nombreUsuario){ //Libros, rentas y cerrar sesión
        int op;
        do {
            System.out.println("\nBIENVENIDO CLIENTE");
            System.out.println("Elige una opción: ");
            System.out.println("1. Consultar libros\n2. Rentar libro\n3. Cerrar sesión");
            op= scanner.nextInt();
        } while (op>3);
        switch(op) {
            case 1: consultarLibros();
                    break;
            case 2: rentarLibro();
                    break;
            case 3: usuarioEnLinea.obtenerInstancia().cerrarSesion();
                    iniciarSesión();
                    break;
        }
       
    }
    
    public void mostrarMenuAsistente(String nombreUsuario){
        int op;
        do {
            System.out.println("\nBIENVENIDO ASISTENTE");
            System.out.println("Elige una opción: ");
                System.out.println("1.Registrar libros prestados \n2. Crear credencial para préstamso"
                        + "\n3. Registrar opiniones de los clientes\n4. Cerrar sesión");
            op= scanner.nextInt();
        } while (op>4);
        switch(op) {
            case 1: librosPrestados();
                    break;
            case 2: crearCredenciales();
                    break;
            case 3: opinionesClientes();
                    break;
            case 4: usuarioEnLinea.obtenerInstancia().cerrarSesion();
                    iniciarSesióñn();
                    break;
        }
    }
    
    public void mostrarMenuGerente (String nombreUsuario){ //Eliminar asistente y hacer rentas
        int op;
        do {
            System.out.println("\nBIENVENIDO GERENTE");
            System.out.println("Elige una opción: ");
                System.out.println("1. Rentar libro\n2. Asignar asistente\n3. Eliminar asistente\n"
                        + "4. Agregar nuevos libros\n5. Eliminar libros\n6. Cerrar sesión");
            op= scanner.nextInt();
        } while (op>6);
        switch(op) {
            case 1: rentarLibroGerente();
                    break;
            case 2: asignarAsistente();
                    break;
            case 3: eliminarAsistente();
                    break;
            case 4: agregarLibros();
                    break;
            case 5: eliminarLibro();
                    break;
            case 6: usuarioEnLinea.obtenerInstancia().cerrarSesion();
                    iniciarSesión();
                    break;   
        }
    }
    
    public void cerrarSesion() {
        boolean datosCorrectos = true;
        String usuario = null;
        String contrasena = null;
        Usuario newUsuario = libreria.verificarInicioSesión(usuario, contrasena);
        if (newUsuario == null) {
            datosCorrectos = false;
            System.out.println("Se cerró la sesión");
            System.out.println("Hasta luego!!");
        }
    }
    ////////////////////Cliente
    private void consultarLibros(){
        
    }
    private void rentarLibro(){
        
    }
    
    ////////////////////Gerente
    private void rentarLibroGerente(){
        
    }
    private void asignarAsistente(){
        
    }
    private void eliminarAsistente(){
        
    }
    private void agregarLibros(){
        
    }
    private void eliminarLibro(){
        
    }
    ///////////////////Asistente
    private void librosPrestados(){
        
    }
    private void crearCredenciales (){
        
    }
    private void opinionesClientes(){
        
    }
}
