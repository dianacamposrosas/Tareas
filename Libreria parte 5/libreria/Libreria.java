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
import java.util.Map;
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
        for(Map.Entry<Rol,ArrayList<Usuario>> entry : usuarios.entrySet()){
            for(Usuario usuario : entry.getValue()) {
                if( usuario.getNombre().equals(nombreUsuario)&& usuario.getContraseña().equals(contraseña)){
                    return usuario;
                }
            }
            
        }
        return null;
    }
    
    public void registrarLibro() {
        Libro.registrarLibro();
    }
    public void registrarCliente() {
        Cliente.registrarCliente();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }
    
     public void registrarGerente() {
        Administrador.registrarGerente();
    }

    public void registrarAsistente() {
        Asistente.registrarAsistente();
        
    }
    public void mostrarGerentes() {
        Administrador.mostrarGerentes();
    }

    public void mostrarAsistentes() {
        Asistente.mostrarAsistentes();
        
    }

    public void eliminarClientes() {
        Cliente.eliminarClientes();

    }

    public void eliminarAsistente() {
        Asistente.eliminarAsistente();
    }

    public void eliminarGerente() {
        Administrador.eliminarGerente();
    }


}
