package libreria;

import utils.Rol;

public class Usuario {
    
    private static int CANTIDAD_USUARIOS;
    private int ID;
    private String nombre;
    private String apellido;
    private String teléfono;
    private Rol rol; //Cliente, asistente, gerente

    public Usuario(String nombre, String apellido, String teléfono, Rol rol) {
        this.ID = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.teléfono = teléfono;
        this.rol = rol;
        CANTIDAD_USUARIOS++;
    }
     @Override
    public String toString() {
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, Rol: %s ",
                ID, nombre, apellido, teléfono, rol);
    }

    public static int getCANTIDAD_USUARIOS() {
        return CANTIDAD_USUARIOS;
    }

    public static void setCANTIDAD_USUARIOS(int CANTIDAD_USUARIOS) {
        Usuario.CANTIDAD_USUARIOS = CANTIDAD_USUARIOS;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
        
}
