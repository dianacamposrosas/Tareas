package libreria;
import java.util.ArrayList;
import java.util.Scanner;
public class Libro {
    
    private static ArrayList<Libro> libros = new ArrayList<Libro>();
    static Scanner leer=new Scanner(System.in);
    private String titulo;
    private String fechaLanzamiento;
    private String autor;
    boolean libroDisponible;
    private int IDlibro;
    public static int CODIGO = 100000;

    public Libro(String titulo, String fechaLanzamiento, String authorName, boolean libroDipsonible,int libroID) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.autor = authorName;
        this.libroDisponible = true;
        this.IDlibro = CODIGO;
        CODIGO++;

    }

    public Libro(String titulo, String fechaLanzamiento, String authorName) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.autor = authorName;
        this.IDlibro = CODIGO;
        CODIGO++;
    }

    public Libro(int IDlibro) {
        this.IDlibro = IDlibro;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getIDlibro() {
        return IDlibro;
    }
    public void setIDlibro(int IDlibro) {
        this.IDlibro = IDlibro;
    }
    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String nombre) {
        this.autor = nombre;
    }

    public boolean isLibroDisponible() {
        return libroDisponible;
    }
    public void setLibroDisponible(boolean libroDisponible) {
        this.libroDisponible = libroDisponible;
    }
    public String mostrarLibros(){
        return String.format("Libro: %s, Autor: %s ID: %d", titulo, autor, IDlibro);
    }
    public String mostrarLibrosRentados() {
        return String.format("Libro: %s", titulo);
    }
    
    public static void registrarLibro() {
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
}
