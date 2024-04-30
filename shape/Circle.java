package shape;
import java.util.Scanner;


public class Circle implements ShapeInterface{
    
    Scanner leer = new Scanner(System.in);
    int radio;
    
    public void obtenerRadio(){
        System.out.println("Please enter the radio of the circle (int)");
        radio = leer.nextInt();
    }
    
    @Override
    public void calcularPerimetro(){
        double perimetro= (2*radio*Math.PI);
        System.out.println("The perimeter is: "+perimetro+"cm");
    }
    
    @Override
    public void calcularArea(){
        double area= Math.PI*Math.pow(radio, 2);
        System.out.println("The area is: "+ area+"cm2");
    }
    
}
