package shape;
import java.util.Scanner;

public class Square extends Shape {
    Scanner leer = new Scanner(System.in);
    
    @Override
    public void calcularPerimetro(){
        System.out.println("Please enter the base of the square (int)");
        base= leer.nextInt();
        
        System.out.println("The perimeter is: "+ (base*4));
    }
    
    @Override
    public void calcularArea(){
        System.out.println("The perimeter is: "+ (base*base));
    }
}
