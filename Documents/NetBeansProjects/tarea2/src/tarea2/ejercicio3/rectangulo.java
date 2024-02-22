package tarea2.ejercicio3;

public class rectangulo {
    
    double ancho, altura;
    
    public rectangulo(double ancho, double altura) {
        this.ancho= ancho;
        this.altura=altura;
    }
    public double área () {
        return ancho*altura;
    }
    public double perímetro () {
        return (2*ancho+2*altura);
    }
    
     public static void main (String[] args) {
    rectangulo rectangulo1=new rectangulo (10,20)    ;
    rectangulo rectangulo2= new rectangulo(15.2,20.3);
    rectangulo rectangulo3=new rectangulo (14,18.2)    ;
    rectangulo rectangulo4= new rectangulo(2,8);

    
         System.out.println("Rectángulo 1: \nSu área es de "+rectangulo1.área()+
                            "\nSu perímetro es de: "+rectangulo1.perímetro());
         System.out.println("\nRectángulo 2: \nSu área es de "+rectangulo2.área()+
                            "\nSu perímetro es de: "+rectangulo2.perímetro());
         System.out.println("Rectángulo 3: \nSu área es de "+rectangulo3.área()+
                            "\nSu perímetro es de: "+rectangulo3.perímetro());
         System.out.println("\nRectángulo 4: \nSu área es de "+rectangulo4.área()+
                            "\nSu perímetro es de: "+rectangulo4.perímetro());
    }
}   
    