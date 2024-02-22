package tarea2.ejercicio2;

public class Libro {
 
    String título= "La vuelta al  mundo en 80 días", autor="Diana Campos";
    int año= 2005;
    
    public void mostrarInformacion() {
        System.out.println("Título: " + título);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + año);
    }
 
    public static void main(String[] args) {
        Libro libro1= new Libro();
        System.out.println("Libro 1: ");
        libro1.mostrarInformacion();
        
        libro1.autor="Dana Pastrana";
        libro1.año= 2000;
        libro1.título= "Alicia en el país de las maravillas";
        System.out.println("\nLibro modificado: ");
        libro1.mostrarInformacion();
        
        /*libro1.autor="Adrián Manríquez";
        libro1.año= 1989;
        libro1.título= "Tú";
        System.out.println("\nLibro modificado por segunda vez: ");
        libro1.mostrarInformacion(); */
        
        //Creo otras tres instancias de "Libro"
        Libro libro2= new Libro();
        Libro libro3 = new Libro();
        Libro libro4 = new Libro();
        
        libro2.título = "La heredera";
        libro2.autor = "Marta Gómez";
        libro2.año = 1990;

        libro3.título = "La princesa";
        libro3.autor = "Karla Patricia";
        libro3.año = 2010;

        libro4.título = "Galaxia";
        libro4.autor = "Stephen Hawking";
        libro4.año = 1954;
        
        System.out.println("\nLibro 2: ");
        libro2.mostrarInformacion();

        System.out.println("\nLibro 3: ");
        libro3.mostrarInformacion();

        System.out.println("\nLibro 4: ");
        libro4.mostrarInformacion();
    }
}
