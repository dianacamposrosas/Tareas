package shape;
import java.util.Scanner;


public class Rectangle extends Shape {
    
    Scanner leer = new Scanner(System.in);
    
    @Override
    public void calcularPerimetro(){
        System.out.println("Please enter the base of the rectangle (int)");
        base= leer.nextInt();
        
        System.out.println("Please enter the height of the triangle (int)");
        height = leer.nextInt();
        
        System.out.println("The perimeter is: "+((2*base)+(2*height))+"cm");
    }
    
    @Override
    public void calcularArea(){
        
        System.out.println("The area is: "+ (base*height)+"cm2");
    }
}
