package tarea2;

public class Tarea2 {

    public static void main(String[] args) {
        
        persona persona1 =new persona("Adrián", 18, "hombre");
      persona persona2= new persona ("Camila", 18, "Mujer");
      persona persona3= new persona ("Dana",18, "Mujer");
      persona persona4=new persona ("Gael", 16, "Hombre");
    
      
      
        System.out.println(persona1.imprimir());
        System.out.println(persona2.imprimir());
        System.out.println(persona3.imprimir());
        System.out.println(persona4.imprimir());
        
    }
    
}
