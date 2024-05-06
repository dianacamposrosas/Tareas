package excepciones;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Excepciones {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        /*
        EXCEPCIONES:
        Una excepción es un evento que se produce cuando se ejecuta 
        el programa de forma que interrumpe el flujo normal de instrucciones.
        
        Bloque try: Este bloque contiene el código que podría generar una excepción.
        Bloque catch: Este bloque se ejecuta si se produce una excepción dentro del bloque try.
        */
        
        
        boolean datoValido = false;
        while(!datoValido){
            try {
                System.out.println("¿Qué tipo de excepción desea ejecutar?: ");
                System.out.println("1. Arithmetic exception\n2. Null pointer exception\n"
                + "3. Exception error\n4. Illegal argument exception\n5. "
                + "Illegal state exceptionn\n6. arrayIndexOutOfBoundsException");
                int opcion = scanner.nextInt();
                switch (opcion){
                    case 1: 
                        System.out.println("Ejericio 1: ");
                        excepciónAritmética();
                        System.out.println("Ejercicio 2: ");
                        validarRangoEdad();
                        System.out.println("Ejercicio 3: ");
                        conversiónIncorrecta();
                        break;
                    case 2: 
                        nullPointerException();
                        break;
                    case 3:
                        exceptionError();
                        break;
                    case 4:
                        illegalArgumentException ();
                        break;
                    case 5:
                        System.out.println("Ejericio 1: ");
                        illegalStateException ();
                        System.out.println("Ejercicio 2: ");
                        illegalStateException2();
                        break;
                    case 6: 
                        arrayIndexOutOfBoundsException();
                        break;
                }
                break;
            }
            catch(Exception error){
                System.out.println("Ingrese un número válido");
                datoValido=false;
                scanner.next();
            }
            
        }
        System.out.println("Se ha terminado el programa.");            
    }
    
    public static void excepciónAritmética(){
        try {
            int resultado = 10 / 0;
            }
        catch (ArithmeticException error) {
            System.out.println("Ocurrió una división por cero");
            }
    }
    
    public static void  nullPointerException(){
        /*
        La NullPointerException es una excepción no verificada que se 
        produce en Java cuando se intenta acceder a un miembro o método 
        de un objeto que tiene un valor nulo. 
        */
        try {
            String nombre = null;
            System.out.println(nombre.length());
            }
        catch (NullPointerException error) {
            System.out.println("Es de tipo null pointer");
            }
    }
    
    public static void exceptionError(){
        try {
            System.out.println("Ingresa tu edad");
            int edad = scanner.nextInt();
            System.out.println(edad);
        } catch (Exception error){
            System.out.println("Ocurrió un error");
        }
    }
    
    public static void  illegalArgumentException (){
        /*
        La excepción IllegalArgumentException es una excepción no verificada 
        en Java que se lanza para indicar que se ha pasado un argumento ilegal 
        o inapropiado a un método.
        */
        try {
            String edadString = "Hola";
            int edad = Integer.parseInt(edadString);
        } catch (IllegalArgumentException error) {
            System.out.println("El argumento no es válido");
            }
    }
    
    public static void arrayIndexOutOfBoundsException() {
        // Se produce cuando se intenta acceder a un elemento que no existe en el array.
        
        try {
            int[] array = new int[10];
            System.out.println(array[15]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se accedió a un elemento del array fuera de sus límites");
        }
    }
    
    public static void illegalStateException (){
        /*
        La excepción IllegalStateException en Java es una excepción verificada 
        que indica que se ha invocado un método en un momento ilegal o inapropiado. 
        Esto significa que el programa se encuentra en un estado en el que no 
        puede ejecutar la operación solicitada de manera segura o consistente.
        */
        try {
            List<String> lista = new ArrayList<>();
            lista.remove(0);
            } catch (IllegalStateException error) {
                System.out.println("La operación no es válida en el estado actual del objeto");
            }
    }
    
    public static void validarRangoEdad(){
        try {
            int edad;
            System.out.println("Ingresa tu edad: ");
            edad = scanner.nextInt();
            if (edad < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 18");
        }
        System.out.println("Edad registrada: " + edad);
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
    
    public static void illegalStateException2(){
        Map<String, Integer> mapa = new HashMap<>();
        // Se intenta obtener el valor asociado a la clave "nombre", pero 
        //el mapa está vacío, lo que provocará una IllegalStateException
        int valor = mapa.get("nombre");  
    }
    
    public static void conversiónIncorrecta(){
        try {
            String numeroString = "10";
            int numero = Integer.parseInt(numeroString);
            String resultado = numero + " años";
            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println("No se puede convertir la cadena a un número entero");
        }

    }
    
}
