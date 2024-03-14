package tarea8.u2;
import java.util.Scanner;
public class Libros {
    private String título;
    private String autor;
    private String editorial;
    private int año;
    private boolean estaRentado=false;
    private Iterable<Usuarios> usuarios;

    public Libros(String título, String autor, String editorial, int año) {
        this.título = título;
        this.autor = autor;
        this.editorial = editorial;
        this.año = año;
    }
    
    
    /*public Libros(String título, String autor, String editorial, int año) {
        System.out.println("Título: ");
        título = leer.nextLine();
        System.out.println("Autor: ");
        autor = leer.nextLine();
        System.out.println("Editorial: ");
        editorial = leer.nextLine();
        System.out.println("Año de publicación: ");
        año = leer.nextInt();
    }
    static Scanner leer = new Scanner(System.in);
    
   /* public void datosDelLibro () {
        System.out.println("Título: ");
        título = leer.nextLine();
        System.out.println("Autor: ");
        autor = leer.nextLine();
        System.out.println("Editorial: ");
        editorial = leer.nextLine();
        System.out.println("Año de publicación: ");
        año = leer.nextInt();
        
    }*/

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isEstaRentado() {
        return estaRentado;
    }

    public void setEstaRentado(boolean estaRentado) {
        this.estaRentado = estaRentado;
    }
    

    public void setRentado(boolean rentado) {
        this.estaRentado = false;
    }
    
    public String getInformacion(){
       return String.format("Título: %s, Autor: %s, Editorial: %s, Año: %d, ¿Está rentado?: %b",
              título, autor, editorial, año, estaRentado);
    }
    public Usuarios getUsuarioRentado(Libros libro) {
    for (Usuarios usuario : usuarios) {
        for (Libros libroRentado : usuario.getLibrosRentados()) {
            if (libroRentado.equals(libro)) {
                return usuario;
            }
        }
    }
    return null;
    }
}
