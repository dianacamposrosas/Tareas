package tarea2;
public class persona {
    String name, genero;
    int age;
    
    //Método Constructor
    public persona (String name, int age, String genero) {
        this.name= name;
        this.age= age;
        this.genero= genero;
    }
    
    public String imprimir(){
       /* return "Nombre: " + name + "\nEdad: " + age + "\nGénero: " + genero; */
       return String.format(
        "Name: %s \n Age: %d \n genero: %s \n", name, age, genero
        );
    }
}