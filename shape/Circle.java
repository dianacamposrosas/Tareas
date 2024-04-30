package shape;
import java.util.Scanner;


public class Circle extends Shape{
    
    Scanner leer = new Scanner(System.in);
    
    @Override
    public void calcularPerimetro(){
        System.out.println("Please enter the radio of the circle (int)");
        int radio= leer.nextInt();
        
        System.out.println("The perimeter is: "+(2*3.1416*radio));
    }
    
    @Override
    public void calcularArea(){
        System.out.println("Please enter the radio of the circle (int)");
        int radio= leer.nextInt();
        System.out.println("The area is: "+ (3.1416*(radio*radio)));
    }
}
